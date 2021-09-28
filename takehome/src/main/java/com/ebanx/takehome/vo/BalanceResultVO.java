package com.ebanx.takehome.vo;

public class BalanceResultVO {

    AccountVO origin;
    AccountVO destination;

    public void setDestination(AccountVO accountVO) {
        this.destination = accountVO;
    }
    public void setOrigin(AccountVO accountVO) { this.origin = accountVO; }

}
