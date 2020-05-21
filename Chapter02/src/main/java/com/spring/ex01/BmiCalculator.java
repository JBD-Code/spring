package com.spring.ex01;

public class BmiCalculator {
	
	private double nomal; 
	private double lowWeight;
	private double overWeight; 
	private double obesity;
	
	
	public void bmiCalculator(double weight, double height) {
		
		double h =height*0.01;
		double result = weight/(h*h);

		System.out.println("BMI =" + (int)result);
		
		if(result >obesity) {
			
			System.out.println("Result = " +result +"\n" +"비만입니다" );
	
		}else if(result>overWeight) {
		
			System.out.println("Result = " +result +"\n" +"과체중입니다" );
			
		}else if(result>nomal) {
			
			System.out.println("Result = " +result +"\n" +"정상입니다" );

		}else {
			System.out.println("Result = " +result +"\n" +"저체중입니다" );
				
		}
	}


	public void setNomal(double nomal) {
		this.nomal = nomal;
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
	
}
