package com.cardtransaction.transaction.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cardtransaction.transaction.enums.OperationsTypes;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Transactions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7707900281223259352L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSACTION_ID", nullable = false, unique = true)
	@JsonIgnore
	private Integer transactionId;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Accounts.class)
	@JoinColumn(name = "ACCOUNT_ID")
	@JsonAlias("account")	
	private Accounts accounts;
	
	@Column(name = "OPERATION_TYPE_ID", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	@JsonAlias("operation_type_id")
	private OperationsTypes operationsTypes;
	
	@Column(name = "AMOUNT", nullable = false)
	@JsonAlias("amount")
	private Double amount;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_DATE")
	@JsonIgnore
	private Date eventDate;

}
