package com.ebanx.takehome.resource;

import com.ebanx.takehome.service.AccountService;
import com.ebanx.takehome.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceResource {

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<AccountVO> getBalance(@RequestParam int account_id) {
        AccountVO vo = accountService.getBalance(account_id);
        return vo != null ? ResponseEntity.ok(vo) : ResponseEntity.notFound().build();
    }

}
