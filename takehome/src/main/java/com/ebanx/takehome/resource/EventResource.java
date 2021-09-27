package com.ebanx.takehome.resource;

import com.ebanx.takehome.enums.EventsTypeEnum;
import com.ebanx.takehome.service.EventService;
import com.ebanx.takehome.vo.EventVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventResource {

    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<String> event(@RequestBody  EventVO eventVO) {
        EventsTypeEnum event = EventsTypeEnum.fromString(eventVO.getType());

        switch(event) {
            case DEPOSIT:
                String res = eventService.deposit(eventVO);
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(res);
            case TRANSFER:
                System.out.println("transfer");
                return null;
            case WITHDRAW:
                System.out.println("withdraw");
                return null;
            default :
                System.out.println("unknown");
                return null;
        }

    }

}