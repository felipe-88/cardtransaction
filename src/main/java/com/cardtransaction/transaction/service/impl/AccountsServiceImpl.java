package com.cardtransaction.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cardtransaction.transaction.model.Accounts;
import com.cardtransaction.transaction.repository.AccountsRepository;
import com.cardtransaction.transaction.service.AccountsService;

public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private AccountsRepository accountsRepository;
	
	@Override
	public Accounts findById(Integer accountId) {
		
		return accountsRepository.findById(accountId).get();
	}

	@Override
	public Accounts findByDocumentNumber(String document) {
		
		return accountsRepository.findByDocumentNumber(document).get();
	}

	@Override
	public Accounts createAccount(Accounts account) {
		
		return accountsRepository.save(account);
	}

}
