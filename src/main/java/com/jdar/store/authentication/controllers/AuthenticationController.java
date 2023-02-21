package com.jdar.store.authentication.controllers;

import com.jdar.store.authentication.models.dto.JwtPayloadDto;
import com.jdar.store.authentication.services.IAuthenticationService;
import com.jdar.store.authentication.utils.constants.ResourceEndpoint;
import com.jdar.store.model.dto.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ResourceEndpoint.API_AUTHENTICATION_ENDPOINT)
@RequiredArgsConstructor
public class AuthenticationController {

    private final IAuthenticationService authenticationService;

    @PostMapping(ResourceEndpoint.AUTHENTICATION_VALIDATE_ENDPOINT)
    public DataResponse<JwtPayloadDto> validateIfJwtTokenIsValid(@RequestHeader(name = ResourceEndpoint.AUTHORIZATION_HEADER) String token) {
        return DataResponse.<JwtPayloadDto>builder().data(authenticationService.validateIfTokenIsValid(token)).build();
    }

}