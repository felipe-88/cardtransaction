package com.cardtransaction.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cardtransaction.transaction.model.Transactions;
import com.cardtransaction.transaction.repository.TransactionsRepository;
import com.cardtransaction.transaction.service.TransactionsService;

@Component
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionsRepository transactionsRepository;
	
	@Override
	public Transactions findById(Integer transactionId) {
		return transactionsRepository.findById(transactionId).get();
	}

	@Override
	public Transactions save(Transactions transaction) {
		return transactionsRepository.save(transaction);
	}

}
