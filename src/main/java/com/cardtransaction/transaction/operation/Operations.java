package com.cardtransaction.transaction.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cardtransaction.transaction.model.Transactions;
import com.cardtransaction.transaction.service.AccountsService;
import com.cardtransaction.transaction.service.TransactionsService;

import lombok.extern.slf4j.Slf4j;

import static com.cardtransaction.transaction.enums.OperationsTypes.PAGAMENTO;

import java.util.Date;

@Slf4j
@Component
public class Operations {

	@Autowired
	private TransactionsService transactionsService;
	
	@Autowired
	private AccountsService accountsService;
	
	public Transactions doTransaction(Transactions transaction) {
		Double amount = transaction.getAmount();
		if (amount < 0) {
			log.warn("Impossível realizar a transação com valor negativo para a conta {}", transaction.getAccounts().getAccountId());
			return null;
		}
		transaction.setAccounts(accountsService.findById(transaction.getAccounts().getAccountId()));
		transaction.setEventDate(new Date());
		if (!transaction.getOperationsTypes().equals(PAGAMENTO)) {	
			transaction.setAmount(-amount);
		}
		return transactionsService.save(transaction);			
	}
	
}
