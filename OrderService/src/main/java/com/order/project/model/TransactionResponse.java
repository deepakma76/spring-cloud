package com.order.project.model;

public class TransactionResponse {

	private Order order;
	private String paymentstatus;
	private String transactionid;

	public TransactionResponse(Order order, String paymentstatus, String transactionid) {
		super();
		this.order = order;
		this.paymentstatus = paymentstatus;
		this.transactionid = transactionid;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

}
