package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

//import org.apache.commons.lang3.StringUtils;

//import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
//import edu.uark.models.api.Product;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;



public class TransactionEntity extends BaseEntity<TransactionEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.recordId = ((UUID) rs.getObject(TransactionFieldNames.RECORD_ID));
		this.cashierId = rs.getInt(TransactionFieldNames.CASHIER_ID);
		this.total = rs.getInt(TransactionFieldNames.TOTAL_AMOUNT);
		//this.transactionType = rs.getString(TransactionFieldNames.TRANSACTION_TYPE);
		this.referenceId = ((UUID) rs.getObject(TransactionFieldNames.REFERENCE_ID));
		this.totalItemsSold = rs.getInt(TransactionFieldNames.TOTAL_ITEMS_SOLD);
	}
	
	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.RECORD_ID, this.recordId);
		record.put(TransactionFieldNames.CASHIER_ID, this.cashierId);
		record.put(TransactionFieldNames.TOTAL_AMOUNT, this.total);
		//record.put(TransactionFieldNames.TRANSACTION_TYPE, this.transactionType);
		record.put(TransactionFieldNames.REFERENCE_ID, this.referenceId);
		record.put(TransactionFieldNames.TOTAL_ITEMS_SOLD, this.totalItemsSold);

		return record;
	}
	
	private UUID recordId;
	public UUID getRecordId() {
		return this.recordId;
	}
	public TransactionEntity setRecordId(UUID recordId) {
		if (!this.recordId.equals(recordId)) {
			this.recordId = recordId;
			this.propertyChanged(TransactionFieldNames.RECORD_ID);
		}
		
		return this;
	}	
	
	private int cashierId;
	public int getCashierId() {
		return this.cashierId;
	}
	public TransactionEntity setCashierId(int cashierId) {
		if (this.cashierId != cashierId) {
			this.cashierId = cashierId;
			this.propertyChanged(TransactionFieldNames.CASHIER_ID);
		}
		return this;
	}
	
	private int total;
	public int getTotal() {
		return this.total;
	}
	public TransactionEntity setTotal(int total) {
		if (this.total != total) {
			this.total = total;
			this.propertyChanged(TransactionFieldNames.TOTAL_AMOUNT);
		}
		return this;
	}
	
	private UUID referenceId;
	public UUID getReferenceId() {
		return this.referenceId;
	}
	public TransactionEntity setReferenceId(UUID referenceId) {
		if (!this.referenceId.equals(referenceId)) {
			this.referenceId = referenceId;
			this.propertyChanged(TransactionFieldNames.REFERENCE_ID);
		}
		
		return this;
	}	
	
	
	private int totalItemsSold;
	public int getTotalItemsSold() {
		return this.totalItemsSold;
	}
	public TransactionEntity setTotalItemsSold(int totalItemsSold) {
		if (this.totalItemsSold != totalItemsSold) {
			this.totalItemsSold = totalItemsSold;
			this.propertyChanged(TransactionFieldNames.TOTAL_ITEMS_SOLD);
		}
		return this;
	}
	
	
	public Transaction synchronize(Transaction apiTransaction) {
		this.setRecordId(apiTransaction.getRecordId());
		this.setCashierId(apiTransaction.getCashierId());
		this.setTotal(apiTransaction.getTotal());
		//this.setTransactionType()
		this.setReferenceId(apiTransaction.getReferenceId());
		this.setTotalItemsSold(apiTransaction.getTotalItemsSold());
		
		//apiTransaction.setId(this.getId());
		apiTransaction.setCreatedOn(this.getCreatedOn());
		
		return apiTransaction;
	}
	
	public TransactionEntity() {
		super(DatabaseTable.TRANSACTION);

		this.recordId = new UUID(0, 0);
		this.cashierId = 0;
		this.total = 0;
		this.referenceId = new UUID(0, 0);
		this.totalItemsSold = 0;
	}
	
	public TransactionEntity(Transaction apiTransaction) {
		super(DatabaseTable.TRANSACTION);
		
		this.recordId = apiTransaction.getRecordId();
		this.cashierId = apiTransaction.getCashierId();
		this.total = apiTransaction.getTotal();
		this.referenceId = apiTransaction.getReferenceId();
		this.totalItemsSold = apiTransaction.getTotalItemsSold();

//		try {
//			this.recordId = Integer.parseInt(apiTransaction.getRecordId());
//		} catch (NumberFormatException e) {
//			this.recordId = -1;
//		}
		
	}
	
}