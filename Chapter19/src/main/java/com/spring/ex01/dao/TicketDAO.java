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
	TransactionTemplate transactionTemplate;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
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
		
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				
				try {
					
					template.update(new PreparedStatementCreator() {
						
						@Override
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							//String query = "insert into card(consumerID, amount, paymentDate) values(?,?,?)";
							String query = "insert into card(consumerID, amount) values(?,?)";
							PreparedStatement pstmt = con.prepareStatement(query);
							pstmt.setString(1, dto.getConsumerID());
							//pstmt.setString(1, consumerID);
							pstmt.setInt(2, dto.getAmount());
							//pstmt.setDate(3, dto.getPaymentDate());
							//pstmt.setInt(2, amount);
							return pstmt ;
						}
					});
					
					
					 template.update(new PreparedStatementCreator() {
						
						@Override
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							//String query = "insert into ticket(consumerID, amount, paymentDate) values(?,?,?)";
							String query = "insert into ticket(consumerID, amount) values(?,?)";
							PreparedStatement pstmt = con.prepareStatement(query);
							pstmt.setString(1, dto.getConsumerID());
							//pstmt.setString(1, consumerID);
							pstmt.setInt(2, dto.getAmount());
							//pstmt.setDate(3, dto.getPaymentDate());
							//pstmt.setInt(2, amount);
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
