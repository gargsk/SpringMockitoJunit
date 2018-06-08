package yahoo.garg.sharad.springmockitojunit.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SwaggerUISecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${ldap.url:ldap://mycompany.com:389}")
    private String url;
    @Value("${ldap.domain}:mycompany.com")
    private String domain;
    @Value("${ldap.userDNPattern:}")
    private String userDNPattern;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/", "/list")
//                .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
//                .antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')").antMatchers("/edit-user-*")
//                .access("hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
//                .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
//                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
//                .tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
//        ActiveDirectoryLdapAuthenticationProvider adProvider =
//                new ActiveDirectoryLdapAuthenticationProvider(domain,url);
//        adProvider.setConvertSubErrorCodesToExceptions(true);
//        adProvider.setUseAuthenticationRequestCredentials(true);
//
//        // set pattern if it exists
//        // The following example would authenticate a user if they were a member
//        // of the ServiceAccounts group
//        // (&(objectClass=user)(userPrincipalName={0})
//        //   (memberof=CN=ServiceAccounts,OU=alfresco,DC=mycompany,DC=com))
//        if (userDNPattern != null && userDNPattern.trim().length() > 0)
//        {
//            adProvider.setSearchFilter(userDNPattern);
//        }
//        auth.authenticationProvider(adProvider);
//
//        // don't erase credentials if you plan to get them later
//        // (e.g using them for another web service call)
//        auth.eraseCredentials(false);
    }
}
