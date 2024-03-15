package com.bws.tokenservice.rest.service;

import com.bws.tokenservice.api.request.AuthUserRequest;
import com.bws.tokenservice.api.request.BaseRequest;
import com.bws.tokenservice.api.response.AuthUserResponse;
import com.bws.tokenservice.auth.JwtService;
import com.bws.tokenservice.model.entity.User;
import com.bws.tokenservice.rest.service.interfaces.ITokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import static com.bws.tokenservice.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_USER_SERVICE_FIND_BY_USERNAME;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl implements ITokenService {

    private final RestTemplate restTemplate;

    private final JwtService jwtService;

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_USER_SERVICE_FIND_BY_USERNAME)
    private String findByUsernameFromUserServicePaths;

    @Override
    public AuthUserResponse generateToken(AuthUserRequest request) {

        User localUser = restTemplate.postForObject(findByUsernameFromUserServicePaths, request, User.class);
        AuthUserResponse authUserResponse = new AuthUserResponse();
        authUserResponse.setToken(jwtService.generateToken(localUser));

        return authUserResponse;
    }

    @Override
    public String extractUsernameFromToken(BaseRequest request) {

        return jwtService.extractUsername(jwtService.decryptJwt(request.getToken().split(" ")[1]));

    }


}
