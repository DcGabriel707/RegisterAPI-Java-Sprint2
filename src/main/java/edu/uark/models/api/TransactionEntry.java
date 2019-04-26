package edu.uark.models.api;

import edu.uark.models.entities.TransactionEntryEntity;

import java.time.LocalDateTime;
import java.util.UUID;


public class TransactionEntry {
	//pretty sure this is supposed to be the ID for the product
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public TransactionEntry setId(UUID id) {
		this.id = id;
		return this;
	}

	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public TransactionEntry setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}

	private double price;
	public double getPrice() { return this.price; }
	public TransactionEntry setPrice(double price) {
		this.price = price;
		return this;
	}

	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public TransactionEntry setQuantity(int quantity) {
		this.quantity = quantity;
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


	public TransactionEntry() {
		this.id = new UUID(0, 0);
		this.quantity = 0;
		this.price = 0;
		this.lookupCode = "";
		this.referenceId = new UUID(0, 0);
	}
//Please change to transaction entry entity
	public TransactionEntry(TransactionEntryEntity transactionEntry) {
		this.id = transactionEntry.getId();
		this.lookupCode = transactionEntry.getLookupCode();
		this.price = transactionEntry.getPrice();
		this.quantity = transactionEntry.getQuantity();
		this.referenceId = transactionEntry.getReferenceId();
	}
	
	
}