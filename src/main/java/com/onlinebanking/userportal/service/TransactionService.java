package com.onlinebanking.userportal.service;

import com.onlinebanking.userportal.domain.PrimaryAccount;
import com.onlinebanking.userportal.domain.PrimaryTransaction;
import com.onlinebanking.userportal.domain.SavingsAccount;
import com.onlinebanking.userportal.domain.SavingsTransaction;

import java.util.List;

public interface TransactionService {

    List<PrimaryTransaction> findPrimaryTransactionList(String username);
    List<SavingsTransaction> findSavingsTransactionList(String username);

    void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction);
    void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction);

    void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction);
    void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction);

    void betweenAccountsTransfer(String transferFrom, String transferTo, String amount,
                                 PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws Exception;
}
