/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoo.garg.sharad.springmockitojunit.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author sharad.garg
 */



//          Join point:A point during the execution of a program,such as the execution of a method or the handling of an exception.In Spring AOP,a join point always represents a method execution.
//
//          Advice:Action taken by an aspect at a particular join point.Different types of advice include “around”, “before” and “after” advice.(Advice types are discussed later.)Many AOP
//                 frameworks,including Spring,model an advice as an interceptor and maintain a chain of interceptors around the join point.
//
//          Pointcut:A predicate that matches join points.Advice is associated with a pointcut expression and runs at any join point matched by the pointcut(for example,the execution of a
//                   method with a certain name).The concept of join points as matched by pointcut expressions is central to AOP,and Spring uses the AspectJ pointcut expression language by default.
//
//          Introduction:Declaring additional methods or fields on behalf of a type.Spring AOP lets you introduce new interfaces(and a corresponding implementation)to any
//                       advised object.For example,you could use an introduction to make a bean implement an IsModified interface,to simplify caching.(An introduction is known as an inter-type declaration in the AspectJ community.)
//
//          Target object:An object being advised by one or more aspects.Also referred to as the “advised object”.Since Spring AOP is implemented by using runtime proxies,this object is always a proxied object.
//
//          AOP proxy:An object created by the AOP framework in order to implement the aspect contracts(advise method executions and so on).In the Spring Framework,an AOP proxy is a JDK dynamic proxy or a CGLIB proxy.
//
//          Weaving:linking aspects with other application types or objects to create an advised object.This can be done at compile time(using the AspectJ compiler,for example),load time,or at runtime.Spring AOP,
//                  like other pure Java AOP frameworks,performs weaving at runtime.

@Aspect
public class LoggingAspect {

    @Pointcut("within(yahoo.garg.sharad.springmockitojunit..*)")
    public void log() {
    }


}
