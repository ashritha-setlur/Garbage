package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.beans.Wallet;

@Component(value="repoServices")
public class WalletRepoImpl implements WalletRepo 
{
	//	private Map<String, Customer> data; 
	//	private Map<String,ArrayList<String>> trans;
	
	@Autowired(required=true)
	private EntityManagerFactory entityManagerFactory;
	


	@Transactional
	@Override
	public boolean save(Customer customer) 
	{	
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.flush();
		entityManager.getTransaction().commit();
		

		return true;
	}


	@Override
	public Customer findOne(String mobileNo) 
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Customer.class, mobileNo);

	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Customer cust=null;		

		//		String str="select wall from Wallet wall where c_mobile_no=:cmno";
		//		TypedQuery<Customer> query=entityManager.createQuery(str,Customer.class);
		//		query.setParameter("cmno", mobileNo);
		//		




		cust=new Customer();

		cust=entityManager.find(Customer.class, mobileNo);

		//		cust=query.getSingleResult();

		BigDecimal bal1;

		bal1=cust.getWallet().getBalance();

		bal1=bal1.add(amount);

		Wallet wallet=new Wallet(bal1);

		cust.setWallet(wallet);

		entityManager.merge(cust);

		Transactions t=new Transactions();

		t.setMobileNo(mobileNo);
		t.setTransaction(amount +" was deposited");

		entityManager.persist(t);

		return cust;
	}


	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Customer cust=null;

		//	String str="select wall from Wallet wall where c_mobile_no=:cmno";
		//	TypedQuery<Customer> query=entityManager.createQuery(str,Customer.class);
		//	query.setParameter("cmno", mobileNo);

		cust=new Customer();

		cust=entityManager.find(Customer.class, mobileNo);

		//	cust=query.getSingleResult();

		BigDecimal bal1;

		bal1=cust.getWallet().getBalance();

		bal1=bal1.subtract(amount);

		Wallet wallet=new Wallet(bal1);

		cust.setWallet(wallet);

		entityManager.merge(cust);

		Transactions t=new Transactions();

		t.setMobileNo(mobileNo);
		t.setTransaction(amount +" was withdrawn");

		entityManager.persist(t);

		return cust;


	}


	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Customer cust=null;

		cust=withdrawAmount(sourceMobileNo,amount);
		depositAmount(targetMobileNo,amount);			


		Transactions t=new Transactions();
		t.setMobileNo(sourceMobileNo);
		t.setTransaction(amount +" was send to mobile no "+targetMobileNo);
		entityManager.persist(t);

		Transactions t1=new Transactions();
		t1.setMobileNo(targetMobileNo);
		t1.setTransaction(amount +" was added from mobile no "+sourceMobileNo);
		entityManager.persist(t1);

		return cust;
	}


	@Override
	public List<String> showTransaction(String mobileNo) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<String> message=new ArrayList<String>();

		List<Transactions> message1=new ArrayList<Transactions>();


		String str="select trans from Transactions trans where trans.mobileNo=:cmno";
		TypedQuery<Transactions> query=entityManager.createQuery(str, Transactions.class);
		query.setParameter("cmno",mobileNo);

		message1=query.getResultList();


		Iterator<Transactions> it=message1.iterator();


		while(it.hasNext())
		{
			message.add(it.next().getTransaction());
		}

		return message;

	}


	@Override
	public void startTransaction() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// TODO Auto-generated method stub
		entityManager.getTransaction().commit();
	}


}
