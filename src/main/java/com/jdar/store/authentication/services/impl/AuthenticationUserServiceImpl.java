package com.jdar.store.authentication.services.impl;

import com.jdar.store.authentication.dataprovider.jpa.entity.CustomerEntity;
import com.jdar.store.authentication.dataprovider.jpa.repository.ICustomerRepository;
import com.jdar.store.authentication.models.dto.AuthCustomerDto;
import com.jdar.store.authentication.models.dto.AuthUserDto;
import com.jdar.store.authentication.models.dto.JwtPayloadDto;
import com.jdar.store.authentication.security.JwtValidator;
import com.jdar.store.authentication.services.IAuthenticationUserService;
import com.jdar.store.authentication.utils.constants.Constants;
import com.jdar.store.authentication.utils.constants.ErrorsEnum;
import com.jdar.store.exceptions.clasification.clienterror.InsufficientPermissionsException;
import com.jdar.store.exceptions.clasification.servererror.TechnicalException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationUserServiceImpl implements IAuthenticationUserService {

    private final ICustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtValidator jwtValidator;

    @Override
    public AuthUserDto logInUser(AuthCustomerDto authCustomerDto) {
        try {
            Optional<CustomerEntity> customer = customerRepository.findByEmail(authCustomerDto.getEmail());
            if (customer.isPresent() && bCryptPasswordEncoder.matches(authCustomerDto.getPassword(), customer.get().getPassword())) {
                return AuthUserDto.builder()
                        .userId(String.valueOf(customer.get().getId()))
                        .userEmail(customer.get().getEmail())
                        .userName(customer.get().getName())
                        .logInStatus(true)
                        .jwtPayloadDto(buildUserToken(customer.get()))
                        .build();
            }
        } catch (Exception exception) {
            throw new TechnicalException(ErrorsEnum.ERROR_LOG_IN_USER.getErrorDescription());
        }
        throw new InsufficientPermissionsException(ErrorsEnum.ERROR_LOG_IN_UNAUTHORIZED.getErrorDescription());
    }

    public JwtPayloadDto buildUserToken(CustomerEntity customer) {
        AuthUserDto authUserDto = AuthUserDto.builder()
                .userName(customer.getName())
                .userEmail(customer.getEmail())
                .build();

        return JwtPayloadDto.builder()
                .tokenType(Constants.TOKEN_TYPE)
                .accessToken(jwtValidator.generateJWTToken(authUserDto))
                .issuedAt(LocalDateTime.now())
                .tokenIsValid(Boolean.TRUE)
                .build();
    }

}