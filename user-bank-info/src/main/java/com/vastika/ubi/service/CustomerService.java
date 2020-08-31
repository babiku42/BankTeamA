package com.vastika.ubi.service;

import com.vastika.ubi.module.AccountBalance;
import com.vastika.ubi.module.AccountInfo;

public interface CustomerService {
	int openAccount(AccountInfo info);
	int depositAccount(AccountBalance balance);
	int withdrawAccount(AccountBalance balance);
	 AccountBalance showall(int idType);
}
