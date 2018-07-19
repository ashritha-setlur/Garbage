package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;

public interface WalletRepo 
{
    public boolean save(Customer customer);
	
	public Customer findOne(String mobileNo);
	
	public Customer depositAmount(String mobileNo, BigDecimal amount);
	
	public Customer withdrawAmount(String mobileNo, BigDecimal amount);
	
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount);

	public Transactions showTransactions(String mobileNo);
}
