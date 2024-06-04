package org.example.online_banking_system.config;
// Package imports

import org.example.online_banking_system.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

@EnableWebSecurity

public class SecurityConfig {



  @Bean

  public BCryptPasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();

  }



  @Bean

  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http

        .authorizeHttpRequests(authorizeRequests ->

            authorizeRequests

                .requestMatchers("/signup", "/login", "/").permitAll()

                .anyRequest().authenticated()

        )

        .formLogin(formLogin ->

            formLogin

                .loginPage("/login")

                .defaultSuccessUrl("/", true)

                .permitAll()

        )

        .logout(logout ->

            logout

                .permitAll()

        );



    return http.build();

  }



  @Bean

  public UserDetailsService userDetailsService(UserService userService) {

    return username -> userService.loadUserByUsername(username);

  }

}