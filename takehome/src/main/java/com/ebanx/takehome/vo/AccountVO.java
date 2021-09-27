package com.ebanx.takehome.vo;

import java.math.BigDecimal;

public class AccountVO {

    private String id;
    private BigDecimal balance;

    public String getId(){return this.id;}
    public BigDecimal getBalance(){return this.balance;}

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
