package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.vo.MemberVO;
import com.sun.tracing.dtrace.Attributes;

public interface MemberController {

	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	public ModelAndView memberInsert(@ModelAttribute("member") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView memberDelete(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//public ModelAndView memberUpdate(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response )throws Exception;
	public ModelAndView memberInfo(@ModelAttribute("member")MemberVO memberVO,
								   @RequestParam("id") String id, 
								   HttpServletRequest request, HttpServletResponse response )throws Exception;
}
