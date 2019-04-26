package edu.uark.models.api;

import edu.uark.models.entities.TransactionEntity;

import java.time.LocalDateTime;
import java.util.UUID;

//import org.apache.commons.lang3.StringUtils;


public class TransactionEntry {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public TransactionEntry setId(UUID id) {
		this.id = id;
		return this;
	}

	private int cashierId;
	public int getCashierId() {
		return this.cashierId;
	}
	public TransactionEntry setCashierId(int cashierId) {
		this.cashierId = cashierId;
		return this;
	}

	private int total;
	public int getTotal() {
		return this.total;
	}
	public TransactionEntry setTotal(int total) {
		this.total = total;
		return this;
	}

	//TRANSACTION TYPE METHOD ??

	private UUID referenceId;
	public UUID getReferenceId() {
		return this.referenceId;
	}
	public TransactionEntry setReferenceId(UUID referenceId) {
		this.referenceId = referenceId;
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public TransactionEntry setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	private int totalItemsSold;
	public int getTotalItemsSold() {
		return this.totalItemsSold;
	}
	public TransactionEntry setTotalItemsSold(int totalItemsSold) {
		this.totalItemsSold = totalItemsSold;
		return this;
	}

	public TransactionEntry() {
		this.id = new UUID(0, 0);
		this.cashierId = 0;
		this.total = 0;
		this.referenceId = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
		this.totalItemsSold = 0;
	}

	public TransactionEntry(TransactionEntity transactionEntity) {
		this.id = transactionEntity.getId();
		this.cashierId = transactionEntity.getCashierId();
		this.total = transactionEntity.getTotal();
		this.referenceId = transactionEntity.getReferenceId();
		this.createdOn = transactionEntity.getCreatedOn();
		this.totalItemsSold = transactionEntity.getTotalItemsSold();
	}
	
	
}