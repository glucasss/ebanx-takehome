package com.ebanx.takehome.service;

import com.ebanx.takehome.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public BigDecimal getBalance(int accountId) {
        return accountRepository.findBalanceByAccountId(accountId).orElse(null);
    }
}
