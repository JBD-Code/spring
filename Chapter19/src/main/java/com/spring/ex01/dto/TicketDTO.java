package com.spring.ex01.dto;

import java.sql.Date;

public class TicketDTO {

	private String consumerID; 
	private int amount; 
	private Date paymentDate;
	
	public String getConsumerID() {
		return consumerID;
	}
	public void setConsumerID(String consumerID) {
		this.consumerID = consumerID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	} 
	
	
}
