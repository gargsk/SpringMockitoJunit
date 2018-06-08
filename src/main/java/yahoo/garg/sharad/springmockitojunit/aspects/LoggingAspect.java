/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoo.garg.sharad.springmockitojunit.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author sharad.garg
 */
@Aspect
public class LoggingAspect {
    
    @Pointcut("within(yahoo.garg.sharad.springmockitojunit..*)")
    public void log() {}

    
}
