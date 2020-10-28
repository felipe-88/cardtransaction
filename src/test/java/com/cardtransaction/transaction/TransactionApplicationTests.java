package com.cardtransaction.transaction;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cardtransaction.transaction.enums.OperationsTypes;
import com.cardtransaction.transaction.model.Accounts;
import com.cardtransaction.transaction.model.Transactions;
import com.cardtransaction.transaction.operation.Operations;
import com.cardtransaction.transaction.service.AccountsService;

@SpringBootTest
class TransactionApplicationTests {

	@Autowired
	private AccountsService accountsService;
	
	@Autowired
	private Operations operations;
	
	@Test
	void contextLoads() {
	}
	
	private String generateCPF() {
		Long cpf = RandomUtils.nextLong(10000000000L, 99999999999L);
		return cpf.toString();
	}
	
	@Test
	public void testDoTransactionWithNegativeAmount () {
		Accounts accounts = new Accounts();
		accounts.setDocumentNumber(generateCPF());		
		Transactions transactions = new Transactions();
		transactions.setAccounts(accountsService.createAccount(accounts));
		transactions.setAmount(-55.25);
		transactions.setOperationsTypes(OperationsTypes.PAGAMENTO);
		assertNull(operations.doTransaction(transactions), "Amount < 0");		
	}
	
	@Test
	public void testDoTransactionWithPositiveAmount () {
		Accounts accounts = new Accounts();
		accounts.setDocumentNumber(generateCPF());		
		Transactions transactions = new Transactions();
		transactions.setAccounts(accountsService.createAccount(accounts));
		transactions.setAmount(79.25);
		transactions.setOperationsTypes(OperationsTypes.COMPRA_A_VISTA);
		assertNotNull(operations.doTransaction(transactions), "Amount > 0");		
	}

}
