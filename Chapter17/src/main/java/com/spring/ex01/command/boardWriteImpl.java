package com.spring.ex01.command;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex01.dao.BoardDAO;

public class boardWriteImpl implements BoardCommand {
	
	BoardDAO dao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content"); 
		Date writeDate = new Date(System.currentTimeMillis());
		dao = new BoardDAO(); 
		dao.insert(id, name, title, content, writeDate);
	}

	
}
