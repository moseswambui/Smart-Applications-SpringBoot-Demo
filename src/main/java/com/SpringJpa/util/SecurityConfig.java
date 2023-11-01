/*package com.SpringJpa.util;

import com.SpringJpa.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

public class SecurityConfig extends WebSecurityConfiguration {
    @Autowired
    private UserService userService;

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws  Exception{
        auth.userDetailsService(userService).passwordEncoder((passwordEncoder()))
    }

}
*/