package com.ebanx.takehome.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="account")
public class Account {

    @Id
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
