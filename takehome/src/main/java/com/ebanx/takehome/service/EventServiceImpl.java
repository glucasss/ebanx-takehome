package com.ebanx.takehome.service;

import com.ebanx.takehome.mapper.AccountMapper;
import com.ebanx.takehome.model.Account;
import com.ebanx.takehome.repository.account.AccountRepository;
import com.ebanx.takehome.vo.BalanceResultVO;
import com.ebanx.takehome.vo.EventVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.math.BigDecimal;

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
        } else { //EXISTING ACCOUNT
            BigDecimal newBalance = acc.getBalance().add(eventVO.getAmount());
            acc.setBalance(newBalance);
        }

        accountRepository.save(acc);

        BalanceResultVO vo = AccountMapper.toBalanceResultVO(acc, false);

        return new Gson().toJson(vo);
    }

    @Override
    public String transfer(EventVO eventVO) {
        Account origin = accountRepository.findById(Integer.valueOf(eventVO.getOrigin()))
            .orElseThrow(NotFoundException::new);
        Account destination = accountRepository.findById(Integer.valueOf(eventVO.getDestination()))
            .orElse(null);

        BigDecimal originNewBalance = origin.getBalance().subtract(eventVO.getAmount());
        origin.setBalance(originNewBalance);
        accountRepository.save(origin);

        if(destination == null) {
            destination = new Account();
            destination.setAccountId(Integer.parseInt(eventVO.getDestination()));
            destination.setBalance(eventVO.getAmount());
        } else {
            BigDecimal newDestinationBalance = destination
                    .getBalance().add(eventVO.getAmount());
            destination.setBalance(newDestinationBalance);
        }

        accountRepository.save(destination);

        BalanceResultVO vo = AccountMapper.toTransferResultVO(origin, destination);

        return new Gson().toJson(vo);
    }

    @Override
    public String withdraw(EventVO eventVO) {
        Account acc = accountRepository.findById(Integer.valueOf(eventVO.getOrigin()))
            .orElseThrow(NotFoundException::new);

        BigDecimal newBalance = acc.getBalance().subtract(eventVO.getAmount());
        acc.setBalance(newBalance);

        accountRepository.save(acc);

        BalanceResultVO vo = AccountMapper.toBalanceResultVO(acc, true);

        return new Gson().toJson(vo);
    }

}
