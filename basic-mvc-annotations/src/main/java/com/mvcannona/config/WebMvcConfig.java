package com.mvcannona.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig {

	@Bean
	public HandlerMapping gethanlder()
	{
		SimpleUrlHandlerMapping handler = null;
		handler = new SimpleUrlHandlerMapping();
		Properties mappings = null;
		mappings = new Properties();
		mappings.setProperty("/mvc-annotation.htm", "viewController");	
		handler.setMappings(mappings);
		return handler;
	}
	
	@Bean
	public Controller viewController()
	{  
		ParameterizableViewController parameterizableViewController = null;
		parameterizableViewController = new ParameterizableViewController();
		parameterizableViewController.setViewName("mvc-annotation");
		return  parameterizableViewController;	
	}
	
	@Bean
	public ViewResolver jspViewResolver()
	{
		InternalResourceViewResolver irvr = null;
		irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
}
