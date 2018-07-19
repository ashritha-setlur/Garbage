package com.cg.mypaymentapp.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Wallet")
public class Customer 
{
	@Column(name="c_name")
	private String name;
	@Id
	@Column(name="c_mobile_no")
	
	private String mobileNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="c_wallet_id")
	private Wallet wallet;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="trans_id")
	private Transactions transaction;

	
	//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="transaction_id")
//	private Transactions transaction;
	
	
	public Customer() 
	{
		
	}
	
	public Customer(String name, String mobileNo, Wallet wallet,Transactions transaction) {
		this.name=name;
		this.mobileNo=mobileNo;
		this.wallet=wallet;
		this.transaction=transaction;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
	
	public Transactions getTransaction() {
		return transaction;
	}

	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Customer name=" + name + ", mobileNo=" + mobileNo
				 + wallet;
	}
	
	
}
