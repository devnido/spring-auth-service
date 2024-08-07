package com.example.auth.base.config.security.provider;

import com.example.auth.app.auth.domain.contracts.AuthDataSource;
import com.example.auth.app.auth.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailServiceSecurity implements UserDetailsService {

    private final AuthDataSource authDataSource;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = authDataSource.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(
                        "El usuario " + username + " no existe"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .disabled(false)
                .accountExpired(false)
                .credentialsExpired(false)
                .accountLocked(false)
                .build();
    }

}
