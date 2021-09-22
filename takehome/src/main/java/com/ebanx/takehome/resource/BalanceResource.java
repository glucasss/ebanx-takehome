package com.ebanx.takehome.resource;

import com.ebanx.takehome.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/balance")
public class BalanceResource {

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<BigDecimal> getBalance(@RequestParam int account_id) {
        BigDecimal balance = accountService.getBalance(account_id);
        return balance != null ?
                ResponseEntity.status(HttpStatus.OK).body(balance)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(BigDecimal.ZERO);
    }

}
