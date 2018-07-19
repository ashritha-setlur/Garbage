package com.cg.mypaymentapp.service;

import java.math.BigDecimal;
import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;


public interface WalletService
{
	public Customer createAccount(String name ,String mobileNo, BigDecimal amount);
	
	public Customer showBalance (String mobileNo);
	
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount);
	
	public Customer depositAmount (String mobileNo,BigDecimal amount );
	
	public Customer withdrawAmount(String mobileNo, BigDecimal amount);
	
	public Transactions showTransactions(String mobileNo);
}
