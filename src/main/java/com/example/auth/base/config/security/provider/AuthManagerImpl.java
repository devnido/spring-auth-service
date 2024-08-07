package com.example.auth.base.config.security.provider;

import com.example.auth.app.auth.domain.contracts.AuthManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthManagerImpl implements AuthManager {

    @Override
    public void setUserAsAuthenticated(String username, String encodedPassword) {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, encodedPassword, List.of(authority));
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }
}
