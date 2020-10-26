package com.cardtransaction.transaction.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.cardtransaction.transaction.model.Transactions;

public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {
	
	public Iterable<Transactions> findByOperationsTypes(Integer type); 
	
	public Iterable<Transactions> findByAmount(Double amount);
	
	public Iterable<Transactions> findByAmountLessThan(Double amount);
	
	public Iterable<Transactions> findByAmountGreaterThan(Double amount);
	
	public Iterable<Transactions> findByAmountBetween(Double start, Double finish);
	
	public Iterable<Transactions> findByEventDateAfter(Date eventDate);
	
	public Iterable<Transactions> findByEventDateBefore(Date eventDate);
	
	public Iterable<Transactions> findByEventDateBetween(Date start, Date finish);	
	
}
