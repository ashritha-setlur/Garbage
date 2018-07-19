package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.util.List;
import com.cg.mypaymentapp.beans.Customer;

public interface WalletRepo 
{
    public boolean save(Customer customer);
	
	public Customer findOne(String mobileNo);
	
	public Customer depositAmount (String mobileNo,BigDecimal amount );
	
	public Customer withdrawAmount(String mobileNo, BigDecimal amount);
	
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount);
	
	public List<String> showTransaction(String mobileNo);
	
	public void startTransaction();
	
	public void commitTransaction();

	
}
