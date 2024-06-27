package org.lucifer.theemployeeswebservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurations {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails Mohammed = User.builder().username("Mohammed").password("{noop}Mohammed123").roles("USER", "MANAGER", "ADMIN").build();
        UserDetails Sally = User.builder().username("Sally").password("{noop}Sally123").roles("USER", "MANAGER").build();
        UserDetails Safaa = User.builder().username("Safaa").password("{noop}Safaa123").roles("USER").build();

        return new InMemoryUserDetailsManager(Mohammed, Sally, Safaa);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }

}
