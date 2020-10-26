package com.cardtransaction.transaction.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cardtransaction.transaction.model.Accounts;

@Service
@Transactional
public interface AccountsService {
	
	public Accounts findById(Integer accountId);
	
	public Accounts findByDocumentNumber(String document);
	
	public Accounts createAccount(Accounts account);

}
