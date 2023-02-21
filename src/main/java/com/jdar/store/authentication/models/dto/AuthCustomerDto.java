package com.jdar.store.authentication.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthCustomerDto {

    @JsonProperty("user_email")
    private String email;

    @JsonProperty("user_password")
    private String password;

}
