package com.spring.ex01;

public class Calculator {
	
	//Spring이 적용되지 않음 
	
	public int firstNum; 
	public int secondNum;
	public int getFirstNum() {
		return firstNum;
	} 
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	} 
	
	public void add(int firstNum, int secondNum) {
		System.out.println("add Method ");
		System.out.println( "firstNum + secondNum  = " + (firstNum + secondNum));
	}
	public void sub(int firstNum, int secondNum) {
		System.out.println("sub Method ");
		System.out.println( "firstNum - secondNum  = " + (firstNum - secondNum));

		
	}
	public void multi(int firstNum, int secondNum) {
		System.out.println("multi  Method ");
		System.out.println( "firstNum * secondNum  = " + (firstNum * secondNum));

		
	} 
	public void div(int firstNum, int secondNum) {
		System.out.println("div Method ");
		System.out.println( "firstNum / secondNum  = " + (firstNum / secondNum));
	
	}
	
}
