package com.bws.tokenservice.rest.config;


import com.bws.tokenservice.model.constants.Constants;
import com.bws.tokenservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
@EnableAspectJAutoProxy
@EnableWebSecurity
@Slf4j

public class ApplicationConfiguration {

    private final UserRepository userRepository;


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        try {
            return userRepository::findByUsername;
        } catch (Exception e) {
            log.warn(UsernameNotFoundException.class.getName());
            throw new UsernameNotFoundException(Constants.USER_NOT_FOUND);
        }
    }
}
