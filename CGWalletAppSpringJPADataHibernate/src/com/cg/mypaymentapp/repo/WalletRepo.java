package com.cg.mypaymentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.mypaymentapp.beans.Customer;

public interface WalletRepo extends JpaRepository<Customer, String> {
	
	
	

}
