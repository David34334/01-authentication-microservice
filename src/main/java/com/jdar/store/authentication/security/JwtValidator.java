package com.jdar.store.authentication.security;

import com.jdar.store.authentication.utils.ParseObjectsToJson;
import com.jdar.store.authentication.utils.constants.ErrorsEnum;
import com.jdar.store.exceptions.clasification.clienterror.InvalidRequestException;
import com.jdar.store.exceptions.clasification.servererror.TechnicalException;
import io.fusionauth.jwt.InvalidJWTSignatureException;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.TimeZone;

@Component
@Slf4j
public class JwtValidator {

    @Value("${jwt.token.secret}")
    private String jwtSecretKey;

    @Value("${timezone.date.bogota}")
    private String jwtTimeZone;

    @Value("${jwt.token.expires-in}")
    private int jwtExpiresDate;

    @Value("${jwt.issuer}")
    private String jwtIssuer;

    public String generateJWTToken(Object object) {
        try {
            String subject = ParseObjectsToJson.convertObjectToJson(object);
            Signer signer = HMACSigner.newSHA256Signer(jwtSecretKey);
            TimeZone timeZone = TimeZone.getTimeZone(jwtTimeZone);
            ZonedDateTime zonedDateTime = ZonedDateTime.now(timeZone.toZoneId()).plusSeconds(jwtExpiresDate);
            JWT jwt = new JWT()
                    .setIssuer(jwtIssuer)
                    .setIssuedAt(ZonedDateTime.now(timeZone.toZoneId()))
                    .setSubject(subject)
                    .setExpiration(zonedDateTime);
            return JWT.getEncoder().encode(jwt, signer);
        } catch (Exception exception) {
            throw new TechnicalException(ErrorsEnum.ERROR_GENERATING_JWT_TOKEN.getErrorDescription());
        }
    }

    public boolean validateIfJwtTokenIsValid(String encodedJwt) {
        boolean tokenValid = Boolean.FALSE;
        try {
            Verifier verifierToken = HMACVerifier.newVerifier(jwtSecretKey);
            JWT jwt = JWT.getDecoder().decode(encodedJwt, verifierToken);
            if (Objects.nonNull(jwt)) {
                tokenValid = Boolean.TRUE;
            }
        } catch (InvalidJWTSignatureException invalidJWTSignatureException) {
            log.error(ErrorsEnum.ERROR_JWT_INVALID_TOKEN.getErrorDescription() + ": " + encodedJwt);
            throw new InvalidRequestException(ErrorsEnum.ERROR_JWT_INVALID_TOKEN.getErrorDescription());
        } catch (Exception exception) {
            log.error(ErrorsEnum.ERROR_JWT_VALIDATING_TOKEN.getErrorDescription() + ": " + encodedJwt);
            throw new TechnicalException(ErrorsEnum.ERROR_JWT_VALIDATING_TOKEN.getErrorDescription());
        }
        return tokenValid;
    }

}
