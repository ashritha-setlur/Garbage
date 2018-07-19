package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cust_Wallet")
public class Wallet 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="wallet_id")
	int walletId;
	
	@Column(name="c_balance")
	private BigDecimal balance;
	
	
	
//	@OneToMany
//	List<Transactions> transactions;

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Wallet(BigDecimal amount) {
		this.balance=amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
		public String toString() {
		return ", balance="+balance;
	}
}
