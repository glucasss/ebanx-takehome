package com.ebanx.takehome.service;

import com.ebanx.takehome.vo.EventVO;

public interface EventService {

    String deposit(EventVO eventVO);
    String withdraw(EventVO eventVO);
}
