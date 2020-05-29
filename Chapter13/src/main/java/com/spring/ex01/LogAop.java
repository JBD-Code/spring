package com.spring.ex01;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "is Start");
		long st = System.currentTimeMillis();
	
		System.out.println("Start Time" + st);
		
		try {
			Object obj = joinpoint.proceed();
			return obj;

		} finally {
			long et =System.currentTimeMillis();
			System.out.println(signatureStr + " is finished");
			System.out.println(signatureStr + " Time " + (st-et));
		}
		
	} 
}
