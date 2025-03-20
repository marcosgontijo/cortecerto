package br.com.ninodev.cortecerto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Configuração de usuários em memória (apenas para fins de exemplo)
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("1234")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

    // Configuração do filtro de segurança
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/clientes/**").permitAll()  // Acesso público
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Acesso restrito para admin
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Página de login customizada, caso queira
                        .permitAll()           // Permitir acesso a todos na página de login
                );

        return http.build();
    }
}
