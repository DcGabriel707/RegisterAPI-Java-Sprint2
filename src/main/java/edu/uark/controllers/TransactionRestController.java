package edu.uark.controllers;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uark.commands.products.ProductCreateCommand;
import edu.uark.models.api.Product;
import edu.uark.commands.transaction.TransactionCreateCommand;
//import edu.uark.commands.transaction.ProductDeleteCommand;
import edu.uark.commands.transaction.TransactionQuery;
//import edu.uark.commands.transaction.ProductUpdateCommand;
import edu.uark.commands.transaction.TransactionQuery;
import edu.uark.models.api.Product;




import edu.uark.commands.products.*;
import edu.uark.models.api.Product;
import edu.uark.models.api.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionRestController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Transaction> getProducts() {
		return (new TransactionQuery()).execute();
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (TransactionRestController)";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody Product product) {
		return (new TransactionCreateCommand()).
			setApiTransaction(product).
			execute();
	}
	
}
