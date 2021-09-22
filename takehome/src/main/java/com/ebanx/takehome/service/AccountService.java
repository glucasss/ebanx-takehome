package com.ebanx.takehome.service;

import java.math.BigDecimal;

public interface AccountService {
    BigDecimal getBalance(int accountId);
}
