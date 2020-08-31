package com.vastika.ubi.service;

import com.vastika.ubi.dao.CustomerDao;
import com.vastika.ubi.dao.CustomerDaoImpl;
import com.vastika.ubi.module.AccountBalance;
import com.vastika.ubi.module.AccountInfo;

public class CustomerServiceImpl implements CustomerService{
CustomerDao customer= new  CustomerDaoImpl(); 
	

@Override
public int openAccount(AccountInfo info) {
	// TODO Auto-generated method stub
	return customer.openAccount(info);
}

@Override
public int depositAccount(AccountBalance balance) {
	// TODO Auto-generated method stub
	return customer.depositAccount(balance);
}

@Override
public int withdrawAccount(AccountBalance balance) {
	// TODO Auto-generated method stub
	return customer.withdrawAccount(balance);
}

@Override
public AccountBalance showall(int idType) {
	// TODO Auto-generated method stub
	return customer.showall(idType);
}
}