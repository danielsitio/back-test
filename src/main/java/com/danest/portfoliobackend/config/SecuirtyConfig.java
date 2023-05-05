package com.danest.portfoliobackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecuirtyConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpsSecurity) throws Exception {
        httpsSecurity.authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll())
                .csrf().disable()
                .httpBasic(Customizer.withDefaults());
        return httpsSecurity.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
