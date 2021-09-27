package com.ebanx.takehome.mapper;

import com.ebanx.takehome.model.Account;
import com.ebanx.takehome.vo.AccountVO;
import com.ebanx.takehome.vo.BalanceResultVO;

public class AccountMapper {

    public static AccountVO toVO(Account acc) {
        if(acc == null) {
            return null;
        }

        AccountVO vo = new AccountVO();

        vo.setId(String.valueOf(acc.getAccountId()));
        vo.setBalance(acc.getBalance());

        return vo;
    }

    public static BalanceResultVO toBalanceResultVO(Account acc, Boolean withdraw) {
        if(acc == null) {
            return null;
        }

        BalanceResultVO vo = new BalanceResultVO();
        AccountVO accountVO = new AccountVO();

        accountVO.setId(String.valueOf(acc.getAccountId()));
        accountVO.setBalance(acc.getBalance());
        if(withdraw) {
            vo.setOrigin(accountVO);
        } else {
            vo.setDestination(accountVO);
        }


        return vo;
    }

}
