package com.becode.accountingapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        UserDetails accountant = User.withDefaultPasswordEncoder()
                .username("accountant")
                .password("accountant")
                .roles("ACCOUNTANT")
                .build();

        UserDetails intern = User.withDefaultPasswordEncoder()
                .username("intern")
                .password("intern")
                .roles("INTERN")
                .build();

        return new InMemoryUserDetailsManager(admin, accountant, intern);
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .dispatcherTypeMatchers(HttpMethod.valueOf("/api/public/**")).permitAll() // Allow public access
                                .dispatcherTypeMatchers(HttpMethod.valueOf("/api/admin/**")).hasRole("ADMIN") // Require ADMIN role
                                .dispatcherTypeMatchers(HttpMethod.valueOf("/api/accountant/**")).hasRole("ACCOUNTANT") // Require ACCOUNTANT role
                                .dispatcherTypeMatchers(HttpMethod.valueOf("/api/intern/**")).hasRole("INTERN") // Require INTERN role
                                .anyRequest().authenticated() // Any other request requires authentication
                )
                .httpBasic();

        return http.build();
    }
}
