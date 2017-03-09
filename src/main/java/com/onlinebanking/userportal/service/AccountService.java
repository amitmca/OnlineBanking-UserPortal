package com.onlinebanking.userportal.service;

import com.onlinebanking.userportal.domain.PrimaryAccount;
import com.onlinebanking.userportal.domain.SavingsAccount;

import java.security.Principal;


public interface AccountService {

    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();

    void deposit(String accountType, Double amount, Principal principal);
    void withdraw(String accountType, Double amount, Principal principal);
}
