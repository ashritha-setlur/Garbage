package com.cg.mypaymentapp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transactions")
public class Transactions {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trans_id")
	private int transid;
	
	@Column(name="trans_list")
	private String transaction;

	@Column(name="c_mobile_no")
	private String mobileNo;
	
	public Transactions() {
		super();
		
	}

	public Transactions(int transid, String transaction, String mobileNo) {
		super();
		this.transid = transid;
		this.transaction = transaction;
		this.mobileNo = mobileNo;
	}

	public int getTransid() {
		return transid;
	}

	public void setTransid(int transid) {
		this.transid = transid;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Transactions [transid=" + transid + ", transaction=" + transaction + ", mobileNo=" + mobileNo + "]";
	}

	
	
	
	
}
