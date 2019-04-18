package edu.uark.commands.transaction;

import java.util.List;
import java.util.stream.Collectors;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Transaction;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionQuery implements ResultCommandInterface<List<Transaction>> {
	@Override
	public List<Transaction> execute() {
		return this.transactionRepository.
			all().
			stream().
			map(mp -> (new Transaction(mp))).
			collect(Collectors.toList());
	}

	//Properties
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionQuery setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionQuery() {
		this.transactionRepository = new TransactionRepository();
	}
}