package com.onlinebanking.userportal.service;

import com.onlinebanking.userportal.domain.PrimaryAccount;
import com.onlinebanking.userportal.domain.SavingsAccount;


public interface AccountService {

    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
}
