package com.ebanx.takehome.mapper;

import com.ebanx.takehome.model.Account;
import com.ebanx.takehome.vo.AccountVO;

public class AccountMapper {

    public static AccountVO toVO(Account acc) {
        if(acc == null) {
            return null;
        }

        AccountVO vo = new AccountVO();

        vo.setAccountId(acc.getAccountId());
        vo.setBalance(acc.getBalance());

        return vo;
    }

}
