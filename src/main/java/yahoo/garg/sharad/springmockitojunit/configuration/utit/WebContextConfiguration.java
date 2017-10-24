/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yahoo.garg.sharad.springmockitojunit.configuration.utit;

import java.net.MalformedURLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import yahoo.garg.sharad.springmockitojunit.util.Profiles;

/**
 *
 * @author Sharad Garg
 * Created on Oct 3, 2017 12:59:47 PM
 */
@EnableWebMvc
@Configuration
@Profile(Profiles.UTIT)
public class WebContextConfiguration {
    
    private static final Logger _logger = LoggerFactory.getLogger(WebContextConfiguration.class);
    
    @Bean
    @Profile(Profiles.PROD)
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurerTest() throws MalformedURLException {
	_logger.info("Web context configuration intilizing PropertySourcesPlaceholderConfigurer for DEV profile");
	String activeProfile = System.getProperty("spring.profiles.active");
	_logger.info("Web context configuration active spring profile " + activeProfile);
	String configFilePath = System.getProperty("CONFIG_FILE_PATH");
	_logger.info("Web context configuration active config file path " + configFilePath);
	String propertiesFilename = "application-" + activeProfile.toLowerCase() + ".properties";
	PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
	if (activeProfile.equalsIgnoreCase("local")) {
	    pspc.setLocations(new ClassPathResource(propertiesFilename));
	} else {
	    String configFile = configFilePath.substring(7) + "/" + propertiesFilename;
	    pspc.setLocation(new FileSystemResource(configFile));
	}

	pspc.setIgnoreUnresolvablePlaceholders(false);
	pspc.setIgnoreResourceNotFound(false);
	pspc.setLocalOverride(false);
	_logger.info("Web context configuration PropertySourcesPlaceholderConfigurer initilized");
	return pspc;
    }

}
