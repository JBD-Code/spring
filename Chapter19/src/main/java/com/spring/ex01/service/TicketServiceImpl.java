package com.spring.ex01.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.spring.ex01.dao.TicketDAO;
import com.spring.ex01.dto.TicketDTO;

public class TicketServiceImpl implements TicketService {
	
	private TicketDAO ticketDAO;
	private TransactionTemplate transactionTemplate2;
	
	
	public void setTicketDAO(TicketDAO ticketDAO) {
		this.ticketDAO = ticketDAO;
	}


	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplate2 = transactionTemplate2;
	}


	public TicketDAO getTicketDAO() {
		return ticketDAO;
	}


	@Override
	public void execute(final TicketDTO dto) {
		// TODO Auto-generated method stub
		transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				dto.setAmount(1);
				ticketDAO.payTicket(dto);
				
				dto.setAmount(5);
				ticketDAO.payTicket(dto);
			}
		});
	}

}
