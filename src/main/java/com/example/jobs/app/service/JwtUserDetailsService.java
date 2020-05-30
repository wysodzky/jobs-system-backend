package com.example.jobs.app.service;

import com.example.jobs.app.exception.UserNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserAccountService userAccountService;

    public JwtUserDetailsService(@Lazy UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            return userAccountService.loadUserByUsername(username);
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(username);
        }


    }
}
