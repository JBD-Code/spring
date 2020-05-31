package com.spring.ex01;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override 
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0);
		//검증할 클래스 객체의 클래스 타입 정보를 명시 
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("validate");
		Student student = (Student)target;	
		
		/*
		String studentName= student.getName();
		if(studentName ==null||studentName.trim().isEmpty()) {
			System.out.println("studentNameName is null or empty" );
			errors.reject("name", "trouble");
		}
		int studentAge = student.getAge();
		if(studentAge==0) {
			System.out.println("StudentAge is Null or empty ");
			errors.reject("age", "trouble");
		}
		
		
		String studentEmail = student.getEmail();
		if(studentEmail ==null || studentEmail.trim().isEmpty()) {
			System.out.println("studentNameName is null or empty" );
			errors.reject("email", "trouble");
		}
		 */
		ValidationUtils.rejectIfEmpty(errors, "name", "troble");
		ValidationUtils.rejectIfEmpty(errors, "age", "troble");
		ValidationUtils.rejectIfEmpty(errors, "email", "troble");
		
	
	}
	
}
