package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;

@Component(value="repoServices")
public class WalletRepoImpl implements WalletRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findOne(String mobileNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transactions showTransactions(String mobileNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
