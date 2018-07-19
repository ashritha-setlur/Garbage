package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;


public class Wallet 
{
	private BigDecimal balance;
	
//	{
//		BigDecimal bd = new BigDecimal(("1200"));
//		
//		balance=bd;
//	}
	
	public Wallet() 
	{
		
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
