package com.vastika.ubi.dao;

import com.vastika.ubi.module.AccountBalance;
import com.vastika.ubi.module.AccountInfo;

public interface CustomerDao {
int openAccount(AccountInfo info);
int depositAccount(AccountBalance balance);
int withdrawAccount(AccountBalance balance);
 AccountBalance showall(int idType);
}
