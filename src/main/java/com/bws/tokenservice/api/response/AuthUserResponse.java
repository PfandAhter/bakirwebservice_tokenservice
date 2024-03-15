package com.bws.tokenservice.api.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AuthUserResponse {
    private String token;
}
