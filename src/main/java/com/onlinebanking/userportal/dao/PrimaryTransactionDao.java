package com.onlinebanking.userportal.dao;

import com.onlinebanking.userportal.domain.PrimaryTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
