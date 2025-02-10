package com.shilpi.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${doctor.name}")
    private String doctorUserName;
    @Value("${doctor.password}")
    private String doctorPassword;
    @Value("${doctor.role}")
    private String doctorRole;

    @Value("${patient.name}")
    private String patientUserName;
    @Value("${patient.password}")
    private String patientPassword;
    @Value("${patient.role}")
    private String patientRole;

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails doctor = User.withUsername(doctorUserName)
                .password(passwordEncoder()
                        .encode(doctorPassword))
                .roles(doctorRole)
                .build();

        UserDetails patient = User.withUsername(patientUserName)
                .password(passwordEncoder()
                        .encode(patientPassword))
                .roles(patientRole)
                .build();
        return new InMemoryUserDetailsManager(doctor,patient);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/*/all").hasAnyRole("PATIENT","DOCTOR")
                                .requestMatchers("/**").hasRole("DOCTOR")
//
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }
}
