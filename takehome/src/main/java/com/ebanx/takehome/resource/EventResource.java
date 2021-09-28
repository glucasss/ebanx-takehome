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

import javax.ws.rs.NotFoundException;

@RestController
@RequestMapping("/event")
public class EventResource {

    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<String> event(@RequestBody  EventVO eventVO) {
        EventsTypeEnum event = EventsTypeEnum.fromString(eventVO.getType());
        String res;

        switch(event) {
            case DEPOSIT:
                res = eventService.deposit(eventVO);
                return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(res);
            case TRANSFER:
                try {
                    res = eventService.transfer(eventVO);
                    return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(res);
                } catch (NotFoundException e) {
                    return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("0");
                }
            case WITHDRAW:
                try {
                    res = eventService.withdraw(eventVO);
                    return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(res);
                } catch (NotFoundException e) {
                    return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("0");
                }
            default :
                System.out.println("unknown");
                return null;
        }
    }

}