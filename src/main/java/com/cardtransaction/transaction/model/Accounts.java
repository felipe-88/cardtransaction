package com.cardtransaction.transaction.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Accounts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8112155664942281911L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID", nullable = false, unique = true)
	@JsonAlias("account_id")
	private Integer accountId;
	
	@Column(name = "DOCUMENT_NUMBER", nullable = false, unique = true)
	@JsonAlias("document_number")
	private String documentNumber;
	
	@OneToMany(mappedBy = "accounts")
	@JsonIgnore
	private List<Transactions> transactionsList;
}
