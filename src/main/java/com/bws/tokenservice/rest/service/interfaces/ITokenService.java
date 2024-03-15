package com.bws.tokenservice.rest.service.interfaces;

import com.bws.tokenservice.api.request.AuthUserRequest;
import com.bws.tokenservice.api.request.BaseRequest;
import com.bws.tokenservice.api.response.AuthUserResponse;

public interface ITokenService {

    AuthUserResponse generateToken (AuthUserRequest request);

    String extractUsernameFromToken (BaseRequest request);

}
