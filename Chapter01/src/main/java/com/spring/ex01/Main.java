package com.spring.ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//Spring이 적용되지 않음 
		/*
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setMycalculator(new Calculator());
		
		myCalculator.setFirstNum(1);
		myCalculator.setSecondNum(50);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	
		*/
		String configlocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configlocation);
		MyCalculator mycalculator = ctx.getBean("myCalculator", MyCalculator.class);
		mycalculator.add();
		mycalculator.sub();
		mycalculator.mul();
		mycalculator.div();
		
	
	}
}
