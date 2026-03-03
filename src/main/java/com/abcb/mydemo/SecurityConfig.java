package com.abcb.mydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                // Allow access to the home page, error pages, and static resources
                .requestMatchers("/", "/error", "/styles.css").permitAll()
                // All other requests require authentication
                .anyRequest().authenticated()
            )
            // Enable SAML 2.0 Login
            .saml2Login(withDefaults());

        return http.build();
    }
}
