package com.cardtransaction.transaction.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cardtransaction.transaction.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Integer> {	 
	 
	 public Optional<Accounts> findByDocumentNumber(String document);	 
	
}
