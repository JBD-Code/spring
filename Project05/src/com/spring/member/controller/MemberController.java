package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.ModelAndView;

public interface MemberController {

	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response) throws DataAccessException, Exception; 
	public ModelAndView memberInsert(HttpServletRequest request, HttpServletResponse response) throws DataAccessException, Exception;
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws DataAccessException, Exception;
	public ModelAndView memberUpdate(HttpServletRequest request, HttpServletResponse response) throws DataAccessException, Exception;
	public ModelAndView memberDelete(HttpServletRequest request, HttpServletResponse response) throws DataAccessException, Exception;
}
