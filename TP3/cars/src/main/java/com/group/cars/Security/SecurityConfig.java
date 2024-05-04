package com.group.cars.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    PasswordEncoder passwordEncoder = passwordEncoder ();
   
    UserDetails admin = User
    .withUsername("admin")
    .password(passwordEncoder.encode("123"))
    .authorities("ADMIN")
    .build();
    UserDetails rFuryy = User
    .withUsername("rFuryy")
    .password(passwordEncoder.encode("123"))
    .authorities("AGENT","USER")
    .build();
    UserDetails user1 = User
    .withUsername("user1")
    .password(passwordEncoder.encode("123"))
    .authorities("USER")
    .build();
   
    return new InMemoryUserDetailsManager(admin, rFuryy,user1);
    }
   
}
