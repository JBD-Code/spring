package com.spring.ex01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex01.dao.BoardDAO;

public class boardDeleteImpl implements BoardCommand {
	
	BoardDAO dao ; 
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		dao = new BoardDAO(); 
		dao.delete(idx);
	}

	
}
