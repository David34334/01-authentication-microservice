package com.jdar.store.authentication.services;

import com.jdar.store.authentication.models.dto.AuthCustomerDto;
import com.jdar.store.authentication.models.dto.AuthUserDto;

public interface IAuthenticationUserService {

    AuthUserDto logInUser(AuthCustomerDto authCustomerDto);

}
