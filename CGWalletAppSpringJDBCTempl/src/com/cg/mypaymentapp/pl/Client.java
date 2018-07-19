package com.cg.mypaymentapp.pl;

import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.mypaymentapp.beans.Customer;
//import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.service.WalletService;

public class Client{
	private Scanner console = new Scanner(System.in);
	private Customer customer;
	//private Transactions trans;
	//private Wallet wallet;
	private WalletService serviceObject;
	
	public Client() {
		customer = new Customer();
		//trans=new Transactions();
		ApplicationContext context = new ClassPathXmlApplicationContext("projectbeans.xml");
		serviceObject = (WalletService)context.getBean("walletSevices");
//		serviceObject = new WalletServiceImpl();	
	}
	public void menu(){
		int choice = 0;
		
		System.out.println("-------Welcome to Wallet-------");
		System.out.println();
		System.out.println("1) Create Account.");
		System.out.println("2) Show Balance.");
		System.out.println("3) Deposit.");
		System.out.println("4) Withdraw.");
		System.out.println("5) Fund Transfer.");
		System.out.println("6) Show Transaction.");
		System.out.println();
		System.out.print("Enter your choice: ");
		
		choice = console.nextInt();
		
		switch (choice) {
		case 1:
			//data = new HashMap<String, Customer>();
//			Wallet wallet=new Wallet();
			String customerName = null;
			String customerMobileNo = null;
			String targetMobileNo = null;
			BigDecimal amount = null;
			System.out.println();
			System.out.print("Enter your Name: ");
			customerName = console.next();
			System.out.print("Enter your Mobile Number: ");
			customerMobileNo = console.next();
			System.out.print("Enter the amount of balance: ");
			amount = console.nextBigDecimal();
//			amount=customer.getWallet().getBalance();
			customer = serviceObject.createAccount(customerName, customerMobileNo, amount);
			System.out.println("Your account is created.");	
			System.out.println("With Account Details: ");
			System.out.println(customer);
			
			break;
		case 2:
			System.out.print("Enter your Mobile Number: ");
			customerMobileNo = console.next();
			
			Customer customer=serviceObject.showBalance(customerMobileNo);
			System.out.println(customer);
			
			break;
		case 3:
			System.out.print("Enter your Mobile Number: ");
			customerMobileNo = console.next();
			System.out.print("Enter the amount to be deposited: ");
			amount = console.nextBigDecimal();
			
			Customer customer1=serviceObject.depositAmount(customerMobileNo,amount);
			System.out.println(customer1);
			
			break;
		case 4:
			System.out.print("Enter your Mobile Number: ");
			customerMobileNo = console.next();
			System.out.print("Enter the amount to be withdraw: ");
			amount = console.nextBigDecimal();
			
			Customer customer2=serviceObject.withdrawAmount(customerMobileNo,amount);
			System.out.println(customer2);
			
			break;
		case 5:
			System.out.print("Enter your Mobile Number: ");
			customerMobileNo = console.next();
			System.out.print("Enter Mobile Number to whom you want to transfer: ");
			targetMobileNo = console.next();
			System.out.print("Enter the amount to be transfer: ");
			amount = console.nextBigDecimal();
			
			Customer customer3=serviceObject.fundTransfer(customerMobileNo, targetMobileNo, amount);
			System.out.println(customer3);
			break;
		case 6:
			System.out.print("Enter your Mobile Number: ");
			customerMobileNo = console.next();
						
			
			//trans=serviceObject.showTransactions(customerMobileNo);
			
			
			

			
			
			
			break;
			
		default:
		       System.out.println("Please, enter the right choice!!!");
			break;
		}
		
	}
    public static void main(String[] args)
    {
    	Scanner console = new Scanner(System.in);
		Client client = new Client();
		
		String choice = "yes";
		do
		{
			if(choice.equalsIgnoreCase("yes"))
			{
			client.menu();
			System.out.print("Do you want to continue(yes/no): ");
			choice = console.next();
			}else
			{
				System.out.println("Thank you for using it.");
			}
				
			
		}while(choice.equalsIgnoreCase("yes"));
		
		
		console.close();
	}
}
