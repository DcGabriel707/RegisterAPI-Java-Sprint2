package edu.uark.commands.transaction;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Transaction;
import edu.uark.models.api.Product;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionCreateCommand implements ResultCommandInterface<Transaction> {
	@Override
	public Transaction execute() {

		TransactionEntity transactionEntity = new TransactionEntity(this.apiTransaction);

		
		//No ENTITY object was returned from the database, thus the API object's lookupcode must be unique.
		transactionEntity = new TransactionEntity(apiTransaction); //Create a new ENTITY object from the API object details.
		transactionEntity.save(); //Write, via an INSERT, the new record to the database.
		
		this.apiTransaction.setCreatedOn(transactionEntity.getCreatedOn());
		this.apiTransaction.setId(transactionEntity.getId());
		this.apiTransaction.setCashierId(transactionEntity.getCashierId());
		this.apiTransaction.setTotal(transactionEntity.getTotal());
		this.apiTransaction.setReferenceId(transactionEntity.getReferenceId());
		this.apiTransaction.setTotalItemsSold(transactionEntity.getTotalItemsSold());
		
		return this.apiTransaction;
	}

	//Properties
	private Transaction apiTransaction;
	public Transaction getApiTransaction() {
		return this.apiTransaction;
	}
	public TransactionCreateCommand setApiTransaction(Transaction apiTransaction) {
		this.apiTransaction = apiTransaction;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionCreateCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionCreateCommand() {
		this.transactionRepository = new TransactionRepository();
	}
}
