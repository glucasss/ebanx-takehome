package com.ebanx.takehome.resource;

import com.ebanx.takehome.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reset")
public class ResetResource {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping
    public ResponseEntity<String> reset() {
        accountRepository.deleteAll();
        return ResponseEntity.ok("OK");
    }

}
