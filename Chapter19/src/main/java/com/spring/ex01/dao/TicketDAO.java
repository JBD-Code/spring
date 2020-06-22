package com.spring.ex01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.spring.ex01.dto.TicketDTO;

public class TicketDAO {
	JdbcTemplate template;
	TransactionTemplate transactionTemplate1;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void setTransactionTemplate1(TransactionTemplate transactionTemplate1) {
		this.transactionTemplate1 = transactionTemplate1;
	}
	
	public TicketDAO() {
		System.out.println(template);
	}

	public void payTicket(final TicketDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("payTicket");
		System.out.println(dto.getConsumerID());
		System.out.println(dto.getAmount());
		System.out.println(dto.getPaymentDate());
		
		
		transactionTemplate1.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				
				try {
					
					template.update(new PreparedStatementCreator() {
						
						@Override
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							String query = "insert into card(consumerID, amount) values(?,?)";
							PreparedStatement pstmt = con.prepareStatement(query);
							pstmt.setString(1, dto.getConsumerID());
							pstmt.setInt(2, dto.getAmount());
							return pstmt ;
						}
					});
					
					
					 template.update(new PreparedStatementCreator() {
						
						@Override
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							String query = "insert into ticket(consumerID, amount) values(?,?)";
							PreparedStatement pstmt = con.prepareStatement(query);
							pstmt.setString(1, dto.getConsumerID());
							pstmt.setInt(2, dto.getAmount());
							return pstmt ;
						}
					});
					
						
					} catch (Exception e) {
						System.out.println("Transaction Error = " +e);
						
					}		
			}
		});
		
		
	}

}
