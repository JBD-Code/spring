package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	public ModelAndView listMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
