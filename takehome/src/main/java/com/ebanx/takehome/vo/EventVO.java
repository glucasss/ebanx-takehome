package com.ebanx.takehome.vo;

import java.math.BigDecimal;

public class EventVO {

    String type;
    String destination;
    String origin;
    BigDecimal amount;

    public String getType(){return this.type;}
    public String getDestination(){return this.destination;}
    public String getOrigin(){return this.origin;}
    public BigDecimal getAmount(){return this.amount;}

    public void setType(String type) {
        this.type = type;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
