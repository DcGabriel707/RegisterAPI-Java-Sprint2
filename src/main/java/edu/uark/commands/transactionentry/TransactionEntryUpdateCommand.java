package edu.uark.commands.transactionentry;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.TransactionEntry;
import edu.uark.models.entities.TransactionEntryEntity;
import edu.uark.models.repositories.TransactionEntryRepository;
import edu.uark.models.repositories.interfaces.TransactionEntryRepositoryInterface;

public class TransactionEntryUpdateCommand implements ResultCommandInterface<TransactionEntry> {
	@Override
	public TransactionEntry execute() {
		//Validations
		if (StringUtils.isBlank(this.apiTransactionEntry.getLookupCode())) {
			throw new UnprocessableEntityException("lookupcode");
		}

		TransactionEntryEntity transactionEntryEntity = this.transactionEntryRepository.get(this.transactionEntryId);
		if (transactionEntryEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("transactionEntry");
		}
		
		this.apiTransactionEntry = transactionEntryEntity.synchronize(this.apiTransactionEntry); //Synchronize any incoming changes for UPDATE to the database.
		
		transactionEntryEntity.save(); //Write, via an UPDATE, any changes to the database.
		
		return this.apiTransactionEntry;
	}

	//Properties
	private UUID transactionEntryId;
	public UUID getTransactionEntryId() {
		return this.transactionEntryId;
	}
	public TransactionEntryUpdateCommand setTransactionEntryId(UUID transactionEntryId) {
		this.transactionEntryId = transactionEntryId;
		return this;
	}
	
	private TransactionEntry apiTransactionEntry;
	public TransactionEntry getApiTransactionEntry() {
		return this.apiTransactionEntry;
	}
	public TransactionEntryUpdateCommand setApiTransactionEntry(TransactionEntry apiTransactionEntry) {
		this.apiTransactionEntry = apiTransactionEntry;
		return this;
	}
	
	private TransactionEntryRepositoryInterface transactionEntryRepository;
	public TransactionEntryRepositoryInterface getTransactionEntryRepository() {
		return this.transactionEntryRepository;
	}
	public TransactionEntryUpdateCommand setTransactionEntryRepository(TransactionEntryRepositoryInterface transactionEntryRepository) {
		this.transactionEntryRepository = transactionEntryRepository;
		return this;
	}
	
	public TransactionEntryUpdateCommand() {
		this.transactionEntryRepository = new TransactionEntryRepository();
	}
}
