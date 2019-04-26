package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.TransactionEntry;
import edu.uark.models.entities.fieldnames.TransactionEntryFieldNames;

public class TransactionEntryEntity extends BaseEntity<TransactionEntryEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.lookupCode = rs.getString(TransactionEntryFieldNames.LOOKUPCODE);
		this.quantity = rs.getInt(TransactionEntryFieldNames.QUANTITY);
		this.price=rs.getDouble(TransactionEntryFieldNames.PRICE);
		this.referenceId = ((UUID) rs.getObject(TransactionEntryFieldNames.REFERENCE_ID));
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionEntryFieldNames.LOOKUPCODE, this.lookupCode);
		record.put(TransactionEntryFieldNames.QUANTITY, this.quantity);
		record.put(TransactionEntryFieldNames.PRICE, this.price);
		
		return record;
	}

	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public TransactionEntryEntity setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(TransactionEntryFieldNames.LOOKUPCODE);
		}
		
		return this;
	}
	
	private UUID referenceId;
	public UUID getReferenceId() {
		return this.referenceId;
	}
	public TransactionEntryEntity setReferenceId(UUID referenceId) {
		if (!this.referenceId.equals(referenceId)) {
			this.referenceId = referenceId;
			this.propertyChanged(TransactionEntryFieldNames.REFERENCE_ID);
		}
		
		return this;
	}	
	
	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public TransactionEntryEntity setQuantity(int quantity) {
		if (this.quantity != quantity) {
			this.quantity = quantity;
			this.propertyChanged(TransactionEntryFieldNames.QUANTITY);
		}
		
		return this;
	}

	private double price;
	public double getPrice() {return this.price; }
	public TransactionEntryEntity setPrice(double price) {
		if (this.price != price) {
			this.price = price;
			this.propertyChanged(TransactionEntryFieldNames.PRICE);
		}

		return this;
	}

	public TransactionEntry synchronize(TransactionEntry apiTransactionEntry) {
		this.setQuantity(apiTransactionEntry.getQuantity());
		this.setLookupCode(apiTransactionEntry.getLookupCode());
		this.setReferenceId(apiTransactionEntry.getReferenceId());
		this.setPrice(apiTransactionEntry.getPrice()); // apr-17 kt
		//apiTransactionEntry.setId(this.getId());
		
		return apiTransactionEntry;
	}
	
	public TransactionEntryEntity() {
		super(DatabaseTable.TRANSACTIONENTRY);
		
		this.quantity = -1;
		this.lookupCode = StringUtils.EMPTY;
	}
	
	public TransactionEntryEntity(TransactionEntry apiTransactionEntry) {
		super(DatabaseTable.TRANSACTIONENTRY);
		
		this.quantity = apiTransactionEntry.getQuantity();
		this.price = apiTransactionEntry.getPrice();
		this.referenceId = apiTransactionEntry.getReferenceId();
		this.lookupCode = apiTransactionEntry.getLookupCode();
		
	}
}
