package com.ebanx.takehome.service;

import com.ebanx.takehome.mapper.AccountMapper;
import com.ebanx.takehome.model.Account;
import com.ebanx.takehome.repository.account.AccountRepository;
import com.ebanx.takehome.vo.BalanceResultVO;
import com.ebanx.takehome.vo.EventVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public String deposit(EventVO eventVO) {
        Account acc = accountRepository.findById(Integer.valueOf(eventVO.getDestination()))
            .orElse(null);

        //NEW ACCOUNT
        if(acc == null) {
            acc = new Account();
            acc.setAccountId(Integer.parseInt(eventVO.getDestination()));
            acc.setBalance(eventVO.getAmount());
            accountRepository.save(acc);
        }

        BalanceResultVO vo = AccountMapper.toBalanceResultVO(acc);

        return new Gson().toJson(vo);
    }

}
