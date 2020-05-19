package com.spring.ex04;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("memberController")
public class MemberController {

	@RequestMapping(value="/member/memberForm.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberForm(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav =new ModelAndView();
		mav.setViewName("memberForm");
		
		return mav; 
	}
	
	/*
	@RequestMapping(value="/member/memberResult.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberResult(@RequestParam Map<String, String> memberInfo, 
									HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		String id = memberInfo.get("id");
		String pwd = memberInfo.get("pwd");
		String name = memberInfo.get("name");
		System.out.println("id = " +id  );
		System.out.println("pwd = " +pwd  );
		System.out.println("name = " +name  );
		mav.addObject("memberInfo", memberInfo);
		mav.setViewName("memberResult");
		return mav;
	}
	*/

	@RequestMapping(value="/member/memberResult.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberResult(@ModelAttribute("memberInfo") MemberVO memberVO, 
									HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();

		
		
		System.out.println("id = " +memberVO.getId());
		System.out.println("pwd = " +memberVO.getPwd());
		mav.setViewName("memberResult");
		return mav;
	}
	
}
