package com.ebanx.takehome.vo;

public class BalanceResultVO {

    AccountVO destination;
    AccountVO origin;

    public void setDestination(AccountVO accountVO) {
        this.destination = accountVO;
    }
    public void setOrigin(AccountVO accountVO) { this.origin = accountVO; }

}
