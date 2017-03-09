package com.onlinebanking.userportal.service.serviceImpl;

import com.onlinebanking.userportal.dao.PrimaryAccountDao;
import com.onlinebanking.userportal.dao.SavingsAccountDao;
import com.onlinebanking.userportal.domain.PrimaryAccount;
import com.onlinebanking.userportal.domain.SavingsAccount;
import com.onlinebanking.userportal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class AccountServiceImpl implements AccountService {

    private static int accountNumber = 11223145;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;


    @Override
    public PrimaryAccount createPrimaryAccount() {

        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountDao.save(primaryAccount);

        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }


    @Override
    public SavingsAccount createSavingsAccount() {

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingsAccountDao.save(savingsAccount);

        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }


    private int accountGen() {
        return ++accountNumber;
    }

}
