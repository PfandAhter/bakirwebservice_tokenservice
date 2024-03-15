package com.bws.tokenservice.rest.controller;

import com.bws.tokenservice.api.request.AuthUserRequest;
import com.bws.tokenservice.api.request.BaseRequest;
import com.bws.tokenservice.api.response.AuthUserResponse;
import com.bws.tokenservice.exception.UserNotFoundException;
import com.bws.tokenservice.model.constants.PropertyConstants;
import com.bws.tokenservice.rest.controller.api.TokenRestServiceApi;
import com.bws.tokenservice.rest.service.TokenServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_TOKENSERVICE)
@CrossOrigin
@Slf4j
@RequiredArgsConstructor

public class TokenServiceController implements TokenRestServiceApi {

    private final TokenServiceImpl tokenService;

    @Override
    public ResponseEntity<AuthUserResponse> generateToken(AuthUserRequest authUserRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(tokenService.generateToken(authUserRequest));
    }

    @Override
    public ResponseEntity<String> extractUsernameFromToken(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(tokenService.extractUsernameFromToken(baseRequest));
    }
}
