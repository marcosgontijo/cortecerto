package br.com.ninodev.cortecerto.model;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        return User.builder()
                .username(username)
                .password("admin") // Substitua pela senha real do banco
                .roles("postgres") // Substitua pelos papéis reais do banco
                .build();
    }
}
