package yahoo.garg.sharad.springmockitojunit.initialization;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(2)
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{
    // Register the springSecurityFilter with application war using below mentioned initializer class.
}
