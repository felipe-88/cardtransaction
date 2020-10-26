package com.cardtransaction.transaction.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cardtransaction.transaction.model.Transactions;

@Service
@Transactional
public interface TransactionsService {
	
	public Transactions findById(Integer transactionId);
	
	public Transactions save(Transactions transaction);

}
