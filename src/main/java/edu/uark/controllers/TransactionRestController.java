package edu.uark.controllers;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uark.commands.transaction.TransactionCreateCommand;
import edu.uark.models.api.Transaction;
import edu.uark.commands.transaction.TransactionCreateCommand;
//import edu.uark.commands.transaction.ProductDeleteCommand;
import edu.uark.commands.transaction.TransactionQuery;
//import edu.uark.commands.transaction.ProductUpdateCommand;
import edu.uark.commands.transaction.TransactionQuery;
import edu.uark.models.api.Transaction;
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
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return (new TransactionCreateCommand()).
			setApiTransaction(transaction).
			execute();
	}
	
}
