package com.jdar.store.authentication.services;

import com.jdar.store.authentication.models.dto.JwtPayloadDto;

public interface IAuthenticationService {

    JwtPayloadDto validateIfTokenIsValid(String jwtToken);

}
