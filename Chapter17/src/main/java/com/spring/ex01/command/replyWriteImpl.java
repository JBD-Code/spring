package com.spring.ex01.command;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.ui.Model;

import com.spring.ex01.dao.BoardDAO;

public class replyWriteImpl implements BoardCommand {

	BoardDAO dao ;
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int idx=0;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content"); 
		int bgroup = Integer.parseInt(request.getParameter("bgroup")); 
		Date writeDate = new Date(System.currentTimeMillis());
		dao = new BoardDAO(); 
		dao.insertReply(idx, id, name, title, content, bgroup, writeDate);
	}

}
