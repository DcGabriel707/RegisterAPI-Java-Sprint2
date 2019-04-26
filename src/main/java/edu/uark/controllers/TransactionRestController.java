package edu.uark.controllers;
import edu.uark.commands.transaction.TransactionCreateCommand;
import edu.uark.models.api.Employee;
import edu.uark.models.api.Transaction;
import edu.uark.commands.transaction.TransactionCreateCommand;
//import edu.uark.commands.transaction.ProductDeleteCommand;
import edu.uark.commands.transaction.TransactionQuery;
//import edu.uark.commands.transaction.ProductUpdateCommand;
import edu.uark.commands.transaction.TransactionQuery;
import edu.uark.models.api.Transaction;
import edu.uark.commands.employees.EmployeeUpdateCommand;
import edu.uark.commands.transaction.*;
import edu.uark.models.api.Transaction;
import edu.uark.models.api.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionRestController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Transaction> getTransaction() {
		return (new TransactionQuery()).execute();
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (TransactionRestController)";
	}
	
	@RequestMapping(value = "/{transactionId}", method = RequestMethod.PUT)
	public Transaction updateTransaction(@PathVariable UUID transactionId, @RequestBody Transaction transaction) {
		return (new TransactionUpdateCommand())
			.setTransactionId(transactionId)
			.setApiTransaction(transaction)
			.execute();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return (new TransactionCreateCommand()).
			setApiTransaction(transaction).
			execute();
	}
	
}
