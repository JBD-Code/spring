package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("memberController")
public class MemberController {



	@RequestMapping(value= {"/member/memberForm.do","/member/memberForm1.do"}, method = {RequestMethod.GET})
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberForm");
		return mav; 
	}

	@RequestMapping(value= {"/member/memberResult.do"}, method = {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView memberResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		mav.setViewName("memberResult");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		return mav; 
	}
}
