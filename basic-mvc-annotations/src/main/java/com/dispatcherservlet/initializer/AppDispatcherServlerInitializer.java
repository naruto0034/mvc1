package com.dispatcherservlet.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.mvcannona.config.RootConfig;
import com.mvcannona.config.WebMvcConfig;

@Configuration
public class AppDispatcherServlerInitializer implements WebApplicationInitializer
{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootApplicationContext = null;
		AnnotationConfigWebApplicationContext servletApplicationContext = null;
		ContextLoaderListener contextLoaderListener = null;
		DispatcherServlet dispatcherServlet = null;
		
		rootApplicationContext = new AnnotationConfigWebApplicationContext();
		rootApplicationContext.register(RootConfig.class);
		contextLoaderListener = new ContextLoaderListener(rootApplicationContext);
		servletContext.addListener(contextLoaderListener);
		
		servletApplicationContext = new AnnotationConfigWebApplicationContext();
		servletApplicationContext.register(WebMvcConfig.class);
		dispatcherServlet = new DispatcherServlet(servletApplicationContext);
		ServletRegistration.Dynamic config = servletContext.addServlet("dispatcher",dispatcherServlet);
		config.addMapping("*.htm");
		config.setLoadOnStartup(2);
		
	}

}
