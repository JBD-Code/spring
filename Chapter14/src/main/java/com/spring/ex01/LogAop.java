package com.spring.ex01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

	@Pointcut("within(com.spring.ex01.*)")
	private void pointCutMethod() {
		
	}
	
	@Around("pointCutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint )throws Throwable{
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "is Start");
		long StartTime = System.currentTimeMillis(); 
		System.out.println(StartTime + " Start");
		 
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
			long EndTime = System.currentTimeMillis();
			System.out.println(EndTime + " End");
			System.out.println("StartTime - EndTime = " +(StartTime- EndTime));
		}
		
		
	}
	@Before("within(com.spring.ex01.*)")
	public void beforeAdvice() {
		
	}
}
