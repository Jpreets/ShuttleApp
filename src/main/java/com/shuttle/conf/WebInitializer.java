/**
 * Created Date: 18 April 2016
 * Last Modified Date: 18 April 2016
 */
package com.shuttle.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/service/*" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SecurityConfig.class };
	}

}
