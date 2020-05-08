package com.spring.ex01;

import org.aopalliance.intercept.Invocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("Before Call Method : LogginAdvice ");
		System.out.println(invocation.getMethod() + "Beforee Call Method");
		
		
		Object object = invocation.proceed();
		
		// TODO Auto-generated method stub
		System.out.println("After Call Method : LogginAdvice ");
		System.out.println(invocation.getMethod() + "After Call Method");
		
		return object;
	}

	
	
}
