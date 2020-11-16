package com.spring.ex01.service;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.ui.Model;

import com.spring.ex01.dao.TicketDAO;
import com.spring.ex01.dto.TicketDTO;

public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDAO dao;
	
	public void setDao(TicketDAO dao) {
		this.dao = dao;
	}
	
	public TicketDAO getDao() {
		return dao;
	}

	@Override
	public void execute(TicketDTO ticketDTO) {
		
		
		ticketDTO.getConsumerID();
		System.out.println("서비스 IMpl "+ticketDTO.getConsumerID());
		ticketDTO.getAmount();
		ticketDTO.getPaymentDate();
		System.out.println("서비스 impl = " + ticketDTO.getAmount());
		dao.buyTicket(ticketDTO);
		
		
	}
}
