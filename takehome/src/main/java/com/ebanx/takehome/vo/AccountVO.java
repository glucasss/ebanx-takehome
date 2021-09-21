package com.ebanx.takehome.vo;

import java.math.BigDecimal;

public class AccountVO {

    private int accountId;
    private BigDecimal balance;

    public int getAccountId(){return this.accountId;}
    public BigDecimal getBalance(){return this.balance;}

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
