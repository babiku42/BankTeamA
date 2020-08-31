package com.vastika.ubi.controller;

import java.util.Scanner;

import com.vastika.ubi.module.AccountBalance;
import com.vastika.ubi.module.AccountInfo;
import com.vastika.ubi.service.CustomerService;
import com.vastika.ubi.service.CustomerServiceImpl;

public class CustomerController {
	public double balances;
CustomerService service = new CustomerServiceImpl();
public void openAccount(Scanner input) {
	
	AccountInfo info= getCustomerInfo(input);
	int opened= service.openAccount(info);
	if(opened>=1) {
		System.out.println("Congratulations!!!!!You have sucessfully opened your account");
		
	}
	else {
		System.out.println("Sorry!!!! You have have an error");
	}
	
}
private AccountInfo getCustomerInfo(Scanner input) {
	AccountInfo info= new AccountInfo();
	System.out.println("Enter the Account name");
	String name= input.next();
	System.out.println("enter the address");
	String address= input.next();
	System.out.println(("enter the mobile no"));
	Long mobileNo= input.nextLong();
	System.out.println("enter the idType");
	int idType= input.nextInt();
	
	info.setAccount_name(name);
	info.setAddress(address);
	info.setIdType(idType);
	info.setMobileNo(mobileNo);
	return info;
	
}

public void deposit(Scanner input) {
	AccountBalance balance= getBalance(input);
	System.out.println("Enter the idType");
	int idType= input.nextInt();
	balance.setIdType(idType);
	int deposited= service.depositAccount(balance);
	if(deposited>=1) {
		System.out.println("THe amount is sucessfully deposited");
		
	}else {
		System.out.println("Error");
	}
	
	
}
private AccountBalance getBalance(Scanner input) {
	AccountBalance balance= new AccountBalance();
	System.out.println("enter the amount you want to deposit");
	Double amount= input.nextDouble();
	balances=amount+balances;
	balance.setBalance(balances);
	balance.setDepositAmount(amount);
	
	return balance;
	
	
}
public void withdraw(Scanner input) {
	AccountBalance balance= getWithdraw(input);
	System.out.println("enter the idtype");
	int idType= input.nextInt();
	balance.setIdType(idType);
	int withdraw= service.withdrawAccount(balance);
	if(withdraw>=1) {
		System.out.println("Amount is withdrawn");
		
	}
	else {
		System.out.println("Error!!!!!");
	}
}
private AccountBalance getWithdraw(Scanner input) {
	AccountBalance balance= new AccountBalance();
	System.out.println("enter the amount you want to withdraw");
	Double amount= input.nextDouble();
	balances= balances-amount;
balance.setWithdrawAmount(amount);
balance.setBalance(balances);
return balance;
	
}
public void showAll(Scanner input) {
	System.out.println("enter the idType");
	int idType= input.nextInt();
	AccountBalance balance= service.showall(idType);
	System.out.println("Deposited Amount is "+ balance.getBalance());
	System.out.println("Withdraw amount is "+ balance.getWithdrawAmount());
	System.out.println("New balance is "+ balance.getBalance());
	System.out.println("Id is "+balance.getId());
}
}

