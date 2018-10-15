/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoo.garg.sharad.springmockitojunit.initialization;

import javax.servlet.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import yahoo.garg.sharad.springmockitojunit.configuration.SwaggerUISecurityConfiguration;
import yahoo.garg.sharad.springmockitojunit.configuration.WebCommonContextConfig;

/**
 *
 * @author Sharad Garg Created on Oct 1, 2017 3:05:37 PM
 */
@Order(1)
public class ApplicationInitializer implements WebApplicationInitializer {

    private static final Logger _logger = LoggerFactory.getLogger(ApplicationInitializer.class);

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    
    private static final Class<?>[] configurationClassesDEV = new Class<?>[]{yahoo.garg.sharad.springmockitojunit.configuration.dev.CloudContextConfiguration.class};
    
    private static final Class<?>[] configurationClassesPROD = new Class<?>[]{yahoo.garg.sharad.springmockitojunit.configuration.prod.CloudContextConfiguration.class};
    
    private static final Class<?>[] configurationClassesSQA = new Class<?>[]{yahoo.garg.sharad.springmockitojunit.configuration.sqa.CloudContextConfiguration.class};
    
    private static final Class<?>[] configurationClassesUTIT = new Class<?>[]{yahoo.garg.sharad.springmockitojunit.configuration.utit.CloudContextConfiguration.class,
    };
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
	_logger.info("Application initialization started");
	AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	registerCharacterEncodingFilter(servletContext);
	Environment env  = context.getEnvironment();
	registerDispatcherServlet(servletContext, context, env);
	registerContextLoaderListener(servletContext, context, env);
	registerRequestContextListener(servletContext);
	_logger.info("Application initialization complete");

    }

    private void registerCharacterEncodingFilter(ServletContext servletContext) {
	_logger.info("Registering character encoding filter");
	FilterRegistration.Dynamic characterEncodingFilterRegistration = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
	characterEncodingFilterRegistration.setInitParameter("encoding", "UTF-8");
	characterEncodingFilterRegistration.setInitParameter("forceEncoding", "true");
	characterEncodingFilterRegistration.addMappingForUrlPatterns(null, true, "/*");
	_logger.info("Registering character encoding filter completed");
    } 

    private void registerDispatcherServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext dispatcherContext, Environment env) {
	_logger.info("Dispatcher servlet context initialization started");
	
	switch(env.getActiveProfiles()[0].toUpperCase()){
	    case "DEV":
		createContext(dispatcherContext, yahoo.garg.sharad.springmockitojunit.configuration.dev.WebContextConfiguration.class);
		break;
	    case "SQA":
		createContext(dispatcherContext,yahoo.garg.sharad.springmockitojunit.configuration.sqa.WebContextConfiguration.class);
		break;
	    case "PROD":
		createContext(dispatcherContext, yahoo.garg.sharad.springmockitojunit.configuration.prod.WebContextConfiguration.class);
		break;
	    default:
		createContext(dispatcherContext, yahoo.garg.sharad.springmockitojunit.configuration.utit.WebContextConfiguration.class);
	}
	createContext(dispatcherContext, WebCommonContextConfig.class);
	createContext(dispatcherContext, SwaggerUISecurityConfiguration.class);
	ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(dispatcherContext));
	dispatcher.setLoadOnStartup(1);
	dispatcher.addMapping("/");
	_logger.info("Dispatcher servlet context initialization completed");
    }

    private void registerContextLoaderListener(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext, Environment env) {
	_logger.info("Root application context initialization started");
	switch(env.getActiveProfiles()[0].toUpperCase()){
	    case "DEV":
		createContext(rootContext, configurationClassesDEV);
		break;
	    case "SQA":
		createContext(rootContext,configurationClassesSQA);
		break;
	    case "PROD":
		createContext(rootContext, configurationClassesPROD);
		break;
	    default:
		createContext(rootContext, configurationClassesUTIT);
	}
	_logger.info("Adding  ContextLoaderListener to root context");
	servletContext.addListener(new ContextLoaderListener(rootContext));
	_logger.info("Root application context initilization completed");
    }

    private void registerRequestContextListener(ServletContext servletContext) {
	_logger.info("Adding  RequestContextListener to servlet context");
	servletContext.addListener(new RequestContextListener());
	_logger.info("Added  RequestContextListener to servlet context");
    }

    private void createContext(AnnotationConfigWebApplicationContext context, final Class<?>... annotatedClasses) {
	String classNames = "";
	for (Class<?> annotatedClass : annotatedClasses) {
	    classNames = classNames.concat(annotatedClass.getSimpleName());
	}
	_logger.info("Registering configuration classes to webapplication context {0} ", classNames);
	context.register(annotatedClasses);
    }

}
