package com.acme.doktoric;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	@Before("@annotation(com.acme.doktoric.Loggable)")
	public void BeforeLogger(JoinPoint joinPoint) {
 
		System.out.println("******");
		System.out.println("BeforeLogger() is running!");
		System.out.println("Logged method : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
}
