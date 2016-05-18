/**
 * Created Date: 18 April 2016
 * Last Modified Date: 18 April 2016
 */
package com.shuttle.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc //<mvc:annotation-driven />
@Configuration
@ComponentScan({"com.shuttle"})
@PropertySource("classpath:ShuttleConfig.properties")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Value("${shuttle.directory_route_map}")
    private String directoryRouteMap;
     @Value("${shuttle.directory_driver_photo}")
    private String directoryDriverPhoto;
    @Value("${shuttle.directory_driver_license}")
    private String directoryDriverLicense;
    @Value("${shuttle.directory_driver_id_proof}")
    private String directoryDriverIdProof;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/routeMap/**").addResourceLocations("file://"+directoryRouteMap);
        registry.addResourceHandler("/driverLicense/**").addResourceLocations("file://"+directoryDriverLicense);
        registry.addResourceHandler("/driverPhoto/**").addResourceLocations("file://"+directoryDriverPhoto);
        registry.addResourceHandler("/driverIdProof/**").addResourceLocations("file://"+directoryDriverIdProof);
    }

}
