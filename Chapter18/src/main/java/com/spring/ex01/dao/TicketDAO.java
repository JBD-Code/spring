package com.spring.ex01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition; 
import com.spring.ex01.dto.TicketDTO;

public class TicketDAO {
	
	
	JdbcTemplate template; 
	PlatformTransactionManager transactionManager ;
	
	public TicketDAO() {
		System.out.println("template = " + template);
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	
	
	
	public void buyTicket(final TicketDTO dto) {
	//public void buyTicket(final String consumerID, final int amount) {
		System.out.println("buyTicket");
		System.out.println("dto.getConsumerID : " + dto.getConsumerID());
		//System.out.println("dto.getConsumerID : " +consumerID);
		System.out.println("dto.getAmount : " + dto.getAmount());
		//System.out.println("dto.getAmount : " + amount);
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
 		
		try {
			
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into card(consumerID, amount, paymentDate) values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerID());
				//pstmt.setString(1, consumerID);
				pstmt.setInt(2, dto.getAmount());
				pstmt.setDate(3, dto.getPaymentDate());
				//pstmt.setInt(2, amount);
				return pstmt ;
			}
		});
		
		
		 template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into ticket(consumerID, amount, paymentDate) values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerID());
				//pstmt.setString(1, consumerID);
				pstmt.setInt(2, dto.getAmount());
				pstmt.setDate(3, dto.getPaymentDate());
				//pstmt.setInt(2, amount);
				return pstmt ;
			}
		});
		
		 transactionManager.commit(status);
			
		
		} catch (Exception e) {
			System.out.println("Transaction Error = " +e);
			
			transactionManager.rollback(status);
		}	
	}
	
}
