package com.yifan.yang.StudentMngt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    @Qualifier("securityDataSource")
    private DataSource securityDataSource;

    @Bean
    public UserDetailsManager userDetailsManager() {
        return new JdbcUserDetailsManager(securityDataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/students/showForm*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/students/save*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/students/delete").hasRole("ADMIN")
                        .requestMatchers("/students/**").hasRole("EMPLOYEE")
                        .requestMatchers("/courses/showForm*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/courses/save*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/courses/delete").hasRole("ADMIN")
                        .requestMatchers("/courses/**").hasRole("EMPLOYEE")
                        .requestMatchers("/departments/showForm*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/departments/save*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/departments/delete").hasRole("ADMIN")
                        .requestMatchers("/departments/**").hasRole("EMPLOYEE")
                        .requestMatchers("/instructors/showForm*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/instructors/save*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/instructors/delete").hasRole("ADMIN")
                        .requestMatchers("/instructors/**").hasRole("EMPLOYEE")
                        .requestMatchers("/programs/showForm*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/programs/save*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/programs/delete").hasRole("ADMIN")
                        .requestMatchers("/programs/**").hasRole("EMPLOYEE")
                        .anyRequest().authenticated()
        )
                .formLogin(form ->
                        form
                                .loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                        );
        return http.build();
    }

}