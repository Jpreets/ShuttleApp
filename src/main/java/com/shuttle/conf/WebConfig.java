package com.shuttle.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc //<mvc:annotation-driven />
@Configuration
@ComponentScan({ "com.shuttle" })
public class WebConfig  extends WebMvcConfigurerAdapter {
	
}
