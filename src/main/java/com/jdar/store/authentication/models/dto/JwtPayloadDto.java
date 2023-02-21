package com.jdar.store.authentication.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtPayloadDto {

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("issued_at")
    private LocalDateTime issuedAt;

    @JsonProperty("token_is_valid")
    private boolean tokenIsValid;

}
