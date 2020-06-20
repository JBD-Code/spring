package com.spring.ex01.service;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex01.dao.TicketDAO;
import com.spring.ex01.dto.TicketDTO;

public class TicketServiceImpl implements TicketService {
	
	TicketDAO dao; 
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String consumerID = request.getParameter("consumerID");
		int amount = Integer.parseInt(request.getParameter("amount"));
		Date paymentDate = new Date(System.currentTimeMillis());
		
		TicketDTO dto = new TicketDTO(); 
		dto.setConsumerID(consumerID);
		dto.setAmount(amount);
		dto.setPaymentDate(paymentDate);
		
		dao = new TicketDAO(); 
		dao.buyTicket(dto);
		//dao.buyTicket(consumerID, amount);
		model.addAttribute("dto", dto);
		
	}
	
	

	
}
