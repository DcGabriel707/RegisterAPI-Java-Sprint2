package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import edu.uark.commands.transactionEntry.TransactionEntryCreateCommand;
import edu.uark.commands.transactionEntry.TransactionEntryQuery;
import edu.uark.commands.transactionEntry.TransactionEntryUpdateCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import edu.uark.commands.TransactionEntry.TransactionEntryByLookupCodeQuery;
import edu.uark.commands.transactionEntry.TransactionEntryCreateCommand;
//import edu.uark.commands.TransactionEntry.TransactionEntryDeleteCommand;
import edu.uark.commands.transactionEntry.TransactionEntryQuery;
import edu.uark.commands.transactionEntry.TransactionEntryUpdateCommand;
import edu.uark.models.api.TransactionEntry;

@RestController
@RequestMapping(value = "/api/transactionentry")
public class TransactionEntryRestController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<TransactionEntry> getTransactionEntry() {
		return (new TransactionEntryQuery()).execute();
	}

//
//	@RequestMapping(value = "/byLookupCode/{transactionEntryLookupCode}", method = RequestMethod.GET)
//	public TransactionEntry getProductByLookupCode(@PathVariable String transactionEntryLookupCode) {
//		return (new ProductByLookupCodeQuery()).
//			setLookupCode(transactionEntryLookupCode).
//			execute();
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public TransactionEntry createTransactionEntry(@RequestBody TransactionEntry transactionEntry) {
		return (new TransactionEntryCreateCommand()).
			setApiTransactionEntry(transactionEntry).
			execute();
	}
	
	@RequestMapping(value = "/{transactionEntryId}", method = RequestMethod.PUT)
	public TransactionEntry updateTransactionEntry(@PathVariable UUID transactionEntryId, @RequestBody TransactionEntry transactionEntry) {
		return (new TransactionEntryUpdateCommand()).
			setTransactionEntryId(transactionEntryId).
			setApiTransactionEntry(transactionEntry).
			execute();
	}
	
//	@RequestMapping(value = "/{transactionEntryId}", method = RequestMethod.DELETE)
//	public void deleteProduct(@PathVariable UUID productId) {
//		(new ProductDeleteCommand()).
//			setProductId(productId).
//			execute();
//	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (TransactionEntryRestController)";
	}
}
