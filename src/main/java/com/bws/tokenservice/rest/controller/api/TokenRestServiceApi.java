package com.bws.tokenservice.rest.controller.api;

import com.bws.tokenservice.api.request.AuthUserRequest;
import com.bws.tokenservice.api.request.BaseRequest;
import com.bws.tokenservice.api.response.AuthUserResponse;
import com.bws.tokenservice.model.constants.PropertyConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TokenRestServiceApi {

    @PostMapping(path = PropertyConstants.REQUEST_GENERATETOKEN , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AuthUserResponse> generateToken(@Valid @RequestBody AuthUserRequest authUserRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_EXTRACTUSERNAME , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> extractUsernameFromToken(@Valid @RequestBody BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult);

}
