package com.jdar.store.authentication.controllers;

import com.jdar.store.authentication.models.dto.AuthCustomerDto;
import com.jdar.store.authentication.models.dto.AuthUserDto;
import com.jdar.store.authentication.services.IAuthenticationUserService;
import com.jdar.store.authentication.utils.constants.ResourceEndpoint;
import com.jdar.store.model.dto.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ResourceEndpoint.API_AUTHENTICATION_USER_ENDPOINT)
@RequiredArgsConstructor
public class AuthenticationUserController {

    private final IAuthenticationUserService authenticationUserService;

    @PostMapping
    public DataResponse<AuthUserDto> logInUser(@RequestBody AuthCustomerDto authCustomerDto) {
        return DataResponse.<AuthUserDto>builder().data(authenticationUserService.logInUser(authCustomerDto)).build();
    }

}