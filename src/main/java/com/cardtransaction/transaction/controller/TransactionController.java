package com.cardtransaction.transaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionController {

//	@PostMapping("/accounts")
//	public void createAccounts(@Valid @RequestBody Accounts) {
//		
//	}
	
	@GetMapping("/accounts/{accountId}")
	public void readAccounts(@PathVariable(value = "accountId") Long accountId) {
		
	}
	
//	@PostMapping("/transactions")
//	public void createTransaction(@Valid @RequestBody Transactions) {
//		
//	}
}
