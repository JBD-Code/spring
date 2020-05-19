package com.spring.ex03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("memberController")
public class MemberController {

	@RequestMapping(value = "/member/memberForm.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav= new ModelAndView(); 
		mav.setViewName("memberForm");
		return mav; 
		
	}
	//getParameter() X
	@RequestMapping(value ="/member/memberResult.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberResult(@RequestParam("id")String id , 
									 @RequestParam("pwd")String pwd,
									 HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberResult");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		return mav;  
	}
}
