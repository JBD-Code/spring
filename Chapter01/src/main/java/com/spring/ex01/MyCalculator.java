package com.spring.ex01;

public class MyCalculator {
	 
	
	Calculator mycalculator; 
	private int firstNum;
	private int secondNum; 
	
	public MyCalculator() {}
	
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


	public void add() {
		mycalculator.add(firstNum, secondNum);
	}
	
	public void sub() {
		mycalculator.sub(firstNum, secondNum);
	}
	public void mul() {
		mycalculator.multi(firstNum, secondNum);
	}
	public void div() {
		mycalculator.div(firstNum, secondNum);
	}

	public Calculator getMycalculator() {
		return mycalculator;
	}

	public void setMycalculator(Calculator mycalculator) {
		this.mycalculator = mycalculator;
	}
	
	
	
}
