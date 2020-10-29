package com.cardtransaction.transaction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardtransaction.transaction.model.Accounts;
import com.cardtransaction.transaction.model.Transactions;
import com.cardtransaction.transaction.operation.Operations;
import com.cardtransaction.transaction.service.AccountsService;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	private AccountsService accountsService;
	
	@Autowired
	private Operations operations;
	
	
	@PostMapping("/accounts")
	public ResponseEntity<Accounts> createAccounts(@Valid @RequestBody Accounts account) {
		Accounts accountCreated = accountsService.createAccount(account);
		return new ResponseEntity<Accounts>(accountCreated, HttpStatus.CREATED);
	}
	
	@GetMapping("/accounts/{account_id}")
	public ResponseEntity<Accounts> readAccounts(@PathVariable(value = "account_id") Integer accountId) {
		Accounts account = accountsService.findById(accountId);
		return new ResponseEntity<Accounts>(account, HttpStatus.OK);
	}
	
	@PostMapping("/transactions")
	public ResponseEntity<Transactions> createTransaction(@Valid @RequestBody Transactions transaction) {
		Transactions transactionCreated = operations.doTransaction(transaction);
		return new ResponseEntity<Transactions>(transactionCreated, HttpStatus.CREATED);
	}
}