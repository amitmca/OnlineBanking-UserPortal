package com.onlinebanking.userportal.dao;

import com.onlinebanking.userportal.domain.SavingsTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}
