/**
 * Created Date: 8 April 2016
 * Last Modified Date: 26 April 2016
 */
package com.shuttle.conf;

/**
 *
 * @author Baldeep Singh Kwatra
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
@ComponentScan({"com.shuttle"})
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MongoDBAuthenticationProvider authenticationProvider;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/**/admin/**").access("hasRole('ADMIN')");
        http.authorizeRequests()
                .antMatchers("/**/driver/**").access("hasRole('DRIVER')");

        http.formLogin().loginProcessingUrl("/login_check")
                .defaultSuccessUrl("/service/default")
                .loginPage("/index.html#/login")
                .failureUrl("/index.html#/login?error")
                .usernameParameter("userEmail").passwordParameter("userPassword");
                
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout") ;
                
        http.exceptionHandling().accessDeniedPage("/invalidAccess.html");
                
        http.csrf().disable();

    }

}
