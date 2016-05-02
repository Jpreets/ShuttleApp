/**
 * Created Date: 18 April 2016
 * Last Modified Date: 18 April 2016
 */
package com.shuttle.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc //<mvc:annotation-driven />
@Configuration
@ComponentScan({"com.shuttle"})
public class WebConfig extends WebMvcConfigurerAdapter {

}
