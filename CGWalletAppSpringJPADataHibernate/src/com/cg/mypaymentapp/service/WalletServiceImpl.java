package com.cg.mypaymentapp.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletTransactions;

@Component(value="walletServices")
public class WalletServiceImpl implements WalletService 
{

	@Autowired
	private WalletRepo repo;
	private Customer customer;
	private Wallet wallet;


	@Override
	public Customer createAccount(String name, String mobileNo, BigDecimal amount) 	{
		wallet = new Wallet(amount);
		
		customer = new Customer(name, mobileNo, wallet,new Transactions());
		customer.getTransaction().setMobileNo(mobileNo);
		return repo.save(customer);
	}

	@Override
	public Customer showBalance(String mobileNo) {
		Customer customer=repo.findOne(mobileNo);
		if(customer!=null)
			return customer;
		else
			throw new InvalidInputException("Invalid mobile no.");
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {

		if(sourceMobileNo==null||amount.compareTo(BigDecimal.ZERO)<=0||sourceMobileNo.trim().isEmpty()||targetMobileNo.trim().isEmpty()||targetMobileNo==null)
			throw new InvalidInputException("Inputs cannot be empty.");

		Customer source = repo.findOne(sourceMobileNo);
		Customer target = repo.findOne(targetMobileNo);

		source = withdrawAmount(sourceMobileNo, amount);
		target = depositAmount(targetMobileNo, amount);
		source.getTransaction().getTransaction().add(amount+" was tranfered from your account");
		target.getTransaction().getTransaction().add(amount+" was tranfered to your account");
		repo.save(source);
		repo.save(target);

		return source;
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {

		if(mobileNo==null||amount.compareTo(BigDecimal.ZERO)<=0||mobileNo.trim().isEmpty())
			throw new InvalidInputException("Inputs cannot be empty.");

		Customer customer = repo.findOne(mobileNo);

		customer.getWallet().setBalance(customer.getWallet().getBalance().add(amount));

		repo.save(customer);

		return customer;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) 
	{
		if(mobileNo==null||amount.compareTo(BigDecimal.ZERO)<=0||mobileNo.trim().isEmpty())
			throw new InvalidInputException("Inputs cannot be empty.");

		Customer customer = repo.findOne(mobileNo);

		customer.getWallet().setBalance(customer.getWallet().getBalance().subtract(amount));

		repo.save(customer);

		return customer;

	}

	@Override
	public List<String> showTransaction(String mobileNo) 
	{

		List<String> tr=new ArrayList<String>();

		Transactions transactions = new Transactions();
		
		transactions = trans.f

		return tr;
	}


	public boolean isValid(Customer customer) throws InvalidInputException, InsufficientBalanceException
	{
		if(customer.getName() == null || customer.getName() == "")
		{
			throw new InvalidInputException("User Name cannot be null or empty.");

		}
		if(customer.getMobileNo() == null || customer.getMobileNo() == "")
			throw new InvalidInputException("User Mobile Number cannot be null or empty.");

		BigDecimal value = BigDecimal.ZERO;

		if(customer.getWallet().getBalance() == null ||customer.getWallet().getBalance().compareTo(value)==-1)
			throw new InvalidInputException("Wallet Balance cannot be Null.");

		if(!(customer.getName().matches("^([A-Z]{1}\\w+)$")))
		{
			throw new InvalidInputException("Invalid Name");
		}
		if(!(customer.getMobileNo().length()==10))
			throw new InvalidInputException("Mobile Number is not 10 digit.");

		if(!(customer.getMobileNo().matches("^[7-9]{1}[0-9]{9}$")))
		{
			throw new InvalidInputException("Invalid Number");
		}

		return true;
	}


}
