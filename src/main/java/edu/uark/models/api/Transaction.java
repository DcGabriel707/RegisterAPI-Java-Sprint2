package edu.uark.models.api;

import java.time.LocalDateTime;

import java.util.UUID;

import edu.uark.models.entities.TransactionEntity;

//import org.apache.commons.lang3.StringUtils;


public class Transaction {
	private UUID recordId;
	public UUID getRecordId() {
		return this.recordId;
	}
	public Transaction setRecordId(UUID recordId) {
		this.recordId = recordId;
		return this;
	}
	
	private int cashierId;
	public int getCashierId() {
		return this.cashierId;
	}
	public Transaction setCashierId(int cashierId) {
		this.cashierId = cashierId;
		return this;
	}
	
	private int total;
	public int getTotal() {
		return this.total;
	}
	public Transaction setTotal(int total) {
		this.total = total;
		return this; 
	}
	
	//TRANSACTION TYPE METHOD ??
	
	private UUID referenceId;
	public UUID getReferenceId() {
		return this.referenceId;
	}
	public Transaction setReferenceId(UUID referenceId) {
		this.referenceId = referenceId;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Transaction setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	private int totalItemsSold;
	public int getTotalItemsSold() {
		return this.totalItemsSold;
	}
	public Transaction setTotalItemsSold(int totalItemsSold) {
		this.totalItemsSold = totalItemsSold;
		return this;
	}
	
	public Transaction() {
		this.recordId = new UUID(0, 0);
		this.cashierId = 0;
		this.total = 0;
		this.referenceId = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
		this.totalItemsSold = 0;
	}
	
	public Transaction(TransactionEntity transactionEntity) {
		this.recordId = transactionEntity.getRecordId();
		this.cashierId = transactionEntity.getCashierId();
		this.total = transactionEntity.getTotal();
		this.referenceId = transactionEntity.getReferenceId();
		this.createdOn = transactionEntity.getCreatedOn();
		this.totalItemsSold = transactionEntity.getTotalItemsSold();
	}
	
	
}