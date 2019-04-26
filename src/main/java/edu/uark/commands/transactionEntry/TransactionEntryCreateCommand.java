package edu.uark.commands.transactionEntry;

import edu.uark.models.entities.TransactionEntryEntity;
import edu.uark.models.repositories.TransactionEntryRepository;
import edu.uark.models.repositories.interfaces.TransactionEntryRepositoryInterface;
import org.apache.commons.lang3.StringUtils;
import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.TransactionEntry;

public class TransactionEntryCreateCommand implements ResultCommandInterface<TransactionEntry> {
    @Override
    public TransactionEntry execute() {
        if (StringUtils.isBlank(this.apiTransactionEntry.getLookupCode())) {
            throw new UnprocessableEntityException("lookupcode");
        }

        TransactionEntryEntity transactionEntryEntity = this.transactionEntryRepository.byLookupCode(this.apiTransactionEntry.getLookupCode());
        if (transactionEntryEntity != null) {
            throw new ConflictException("lookupcode"); //Lookupcode already defined for another product.
        }

        //No ENTITY object was returned from the database, thus the API object's lookupcode must be unique.
        transactionEntryEntity = new TransactionEntryEntity(apiTransactionEntry); //Create a new ENTITY object from the API object details.
        transactionEntryEntity.save(); //Write, via an INSERT, the new record to the database.

        this.apiTransactionEntry.setId(transactionEntryEntity.getId()); //Synchronize information generated by the database upon INSERT
		this.apiTransactionEntry.setPrice(transactionEntryEntity.getPrice());
		this.apiTransactionEntry.setQuantity(transactionEntryEntity.getQuantity());
		this.apiTransactionEntry.setLookupCode(transactionEntryEntity.getLookupCode());
		this.apiTransactionEntry.setReferenceId(transactionEntryEntity.getReferenceId());
        return this.apiTransactionEntry;
    }

    //Properties
    private TransactionEntry apiTransactionEntry;
    public TransactionEntry getApiTransactionEntry() {
        return this.apiTransactionEntry;
    }
    public edu.uark.commands.transactionEntry.TransactionEntryCreateCommand setApiTransactionEntry(TransactionEntry apiTransactionEntry) {
        this.apiTransactionEntry = apiTransactionEntry;
        return this;
    }

    private TransactionEntryRepositoryInterface transactionEntryRepository;
    public TransactionEntryRepositoryInterface getTransactionEntryRepository() {
        return this.transactionEntryRepository;
    }
    public edu.uark.commands.transactionEntry.TransactionEntryCreateCommand setTransactionEntryRepository(TransactionEntryRepositoryInterface productRepository) {
        this.transactionEntryRepository = transactionEntryRepository;
        return this;
    }

    public TransactionEntryCreateCommand() {
        this.transactionEntryRepository = new TransactionEntryRepository();
    }
}

