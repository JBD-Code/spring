package com.spring.ex02;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String userID = ""; 
		String userPWD = "" ;
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("UTf-8");
		userID = request.getParameter("id"); 
		userPWD = request.getParameter("pwd"); 
		mav.addObject("userID", userID);
		mav.addObject("userPWD", userPWD);
		mav.setViewName("MemberResult");
		return mav;
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);
		mav.setViewName("MemberInfo");
		
		return mav; 
	}
	
	
}
