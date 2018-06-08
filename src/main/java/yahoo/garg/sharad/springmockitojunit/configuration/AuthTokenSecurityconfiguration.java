package yahoo.garg.sharad.springmockitojunit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class AuthTokenSecurityconfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().authorizeRequests().antMatchers("/", "/list")
//                .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
//                .antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')").antMatchers("/edit-user-*")
//                .access("hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
//                .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
//                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
//                .tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        ActiveDirectoryLdapAuthenticationProvider adProvider =
//                new ActiveDirectoryLdapAuthenticationProvider(domain, url);
//        adProvider.setConvertSubErrorCodesToExceptions(true);
//        adProvider.setUseAuthenticationRequestCredentials(true);
//
//        // set pattern if it exists
//        // The following example would authenticate a user if they were a member
//        // of the ServiceAccounts group
//        // (&(objectClass=user)(userPrincipalName={0})
//        //   (memberof=CN=ServiceAccounts,OU=alfresco,DC=mycompany,DC=com))
//        if (userDNPattern != null && userDNPattern.trim().length() > 0) {
//            adProvider.setSearchFilter(userDNPattern);
//        }
//        auth.authenticationProvider(adProvider);
//
//        // don't erase credentials if you plan to get them later
//        // (e.g using them for another web service call)
//        auth.eraseCredentials(false);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }
}
