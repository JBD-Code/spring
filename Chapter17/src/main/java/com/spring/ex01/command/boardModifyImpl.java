package com.spring.ex01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex01.dao.BoardDAO;

public class boardModifyImpl implements BoardCommand {
	
	BoardDAO dao; 
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int idx = Integer.parseInt(request.getParameter("idx")); 

		String name = request.getParameter("name"); 
		String title= request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(idx );
		dao= new BoardDAO(); 
		dao.modify(idx, name, title, content);
		
	}

	
}
