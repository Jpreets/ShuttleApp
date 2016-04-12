/**
 * ***********************************************************************************
 *
 * Copyright (c)  2016, Mindfire Solutions and/or its affiliates. All rights reserved.
 * ___________________________________________________________________________________
 *
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Mindfire and its suppliers,if any.
 * The intellectual and technical concepts contained
 * herein are proprietary to Mindfire Solutions.
 * and its suppliers and may be covered by us and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Mindfire Solutions.
 */
package com.shuttle.conf;

/**
 *
 * @author Baldeep Singh Kwatra
 */
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
@ComponentScan({"com.shuttle"})
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser("user").password("password").roles("USER");
//    }

    @Autowired
    private MongoDBAuthenticationProvider authenticationProvider;
      
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
    @Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/service/admin/**").access("hasRole('admin')")
		.and()
                  .formLogin().loginProcessingUrl("/login_check")
                  .defaultSuccessUrl("/service/default").
                  loginPage("/login")
                  .failureUrl("/login?error")
		  .usernameParameter("userEmail").passwordParameter("userPassword")
		.and()
		  .logout().logoutSuccessUrl("/login?logout")
//		.and()
//		  .exceptionHandling().accessDeniedPage("/403")
//		.and()
//		  .csrf()
                  ;
              http.csrf().disable();

	}

}