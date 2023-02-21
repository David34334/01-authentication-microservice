package com.jdar.store.authentication.services.impl;

import com.jdar.store.authentication.models.dto.JwtPayloadDto;
import com.jdar.store.authentication.security.JwtValidator;
import com.jdar.store.authentication.services.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final JwtValidator jwtValidator;

    @Override
    public JwtPayloadDto validateIfTokenIsValid(String jwtToken) {
        return JwtPayloadDto.builder()
                .tokenIsValid(jwtValidator.validateIfJwtTokenIsValid(jwtToken))
                .build();
    }

}
