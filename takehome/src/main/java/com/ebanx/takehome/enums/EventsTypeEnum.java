package com.ebanx.takehome.enums;

public enum EventsTypeEnum {

    DEPOSIT("deposit"),
    TRANSFER("transfer"),
    WITHDRAW("withdraw");

    public final String value;

    EventsTypeEnum(String value) {
        this.value = value;
    }

    public static EventsTypeEnum fromString(String value) {
        for(EventsTypeEnum e : EventsTypeEnum.values()) {
            if(e.value.equalsIgnoreCase(value)) {
                return e;
            }
        }
        return null;
    }

}
