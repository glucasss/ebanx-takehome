package com.ebanx.takehome.service;

import com.ebanx.takehome.mapper.AccountMapper;
import com.ebanx.takehome.model.Account;
import com.ebanx.takehome.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.ebanx.takehome.vo.AccountVO;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AccountVO getBalance(int accountId) {
        Account acc = accountRepository.findById(accountId).orElse(null);
        AccountVO vo = AccountMapper.toVO(acc);

        return vo;
    }
}
