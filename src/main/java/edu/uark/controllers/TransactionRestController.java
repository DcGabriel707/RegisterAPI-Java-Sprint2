//package edu.uark.controllers;
//
//import edu.uark.commands.products.*;
//import edu.uark.models.api.Product;
//import edu.uark.models.api.Transaction;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping(value = "/api/transaction")
//public class TransactionRestController {
//
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public List<Transaction> getProducts() {
//		return (new TransactionsQuery()).execute();
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String test() {
//		return "Successful test. (TransactionRestController)";
//	}
//}
