package com.ebanx.takehome.service;

import com.ebanx.takehome.vo.AccountVO;

public interface AccountService {
    AccountVO getBalance(int accountId);
}
