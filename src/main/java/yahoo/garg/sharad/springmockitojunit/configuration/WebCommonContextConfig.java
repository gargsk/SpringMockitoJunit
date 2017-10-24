/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoo.garg.sharad.springmockitojunit.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Sharad Garg Created on 
 *	   Oct 2, 2017 10:15:55 AM
 */
@EnableWebMvc
@Configuration
public class WebCommonContextConfig extends WebMvcConfigurerAdapter {

    private static final Logger _logger = LoggerFactory.getLogger(WebCommonContextConfig.class);

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
    }
    
    
    
    @Override
    public void addViewControllers(final ViewControllerRegistry viewControllerRegistry) {
	viewControllerRegistry.addViewController("/").setViewName("index");
    }
    
}
