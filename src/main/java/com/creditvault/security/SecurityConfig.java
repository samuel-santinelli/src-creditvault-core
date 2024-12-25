package com.creditvault.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Desabilita CSRF para facilitar testes
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/cards").permitAll()  // Permite POST sem autenticação
                .anyRequest().authenticated();  // Exige autenticação para qualquer outra requisição
    }
}
