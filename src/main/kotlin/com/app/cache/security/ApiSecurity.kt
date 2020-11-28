package com.app.cache.security

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@EnableWebSecurity

class ApiSecurity : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()?.authorizeRequests()?.antMatchers("/")?.permitAll()?.and()?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}