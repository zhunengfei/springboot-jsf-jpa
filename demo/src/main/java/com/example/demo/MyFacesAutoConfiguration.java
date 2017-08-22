package com.example.demo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.myfaces.ee6.MyFacesContainerInitializer;
import org.apache.myfaces.webapp.StartupServletContextListener;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
//@ConditionalOnWebApplication
public class MyFacesAutoConfiguration implements ServletContextInitializer {


	@Bean
	public ServletListenerRegistrationBean<StartupServletContextListener> startupServletRegistrationBean(){
		StartupServletContextListener listener = new StartupServletContextListener();
		ServletListenerRegistrationBean<StartupServletContextListener> b = new ServletListenerRegistrationBean<StartupServletContextListener>(listener);
		return b ;
	}

	@Bean
	public ServletListenerRegistrationBean<RequestContextListener> requestContextListenerRegistrationBean(){
		RequestContextListener listener = new RequestContextListener();
		ServletListenerRegistrationBean<RequestContextListener> b = new ServletListenerRegistrationBean<RequestContextListener>(listener);
		return b ;
	}

	@Bean
	public FacesServlet facesServlet() {
		FacesServlet f = new FacesServlet() ;
		return f;
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(facesServlet(), new String[]{"*.xhtml"});
		registration.setName("Faces Servlet");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
	}	
	
	@Bean
	public ServletContainerInitializer getServletContainerInitializer() {
		MyFacesContainerInitializer f = new MyFacesContainerInitializer(){
			
			@Override
			public void onStartup(Set<Class<?>> clazzes, ServletContext servletContext) throws ServletException{
				super.onStartup(clazzes, servletContext);
				
			}
			
		};
		return f ;
	}
	
	

}

