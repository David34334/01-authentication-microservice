package com.jdar.store.authentication.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUserDto {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_email")
    private String userEmail;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("log_in_status")
    private boolean logInStatus;

    @JsonProperty("token")
    private JwtPayloadDto jwtPayloadDto;

}
