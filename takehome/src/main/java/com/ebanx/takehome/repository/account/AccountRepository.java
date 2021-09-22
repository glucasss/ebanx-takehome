package com.ebanx.takehome.repository.account;

import com.ebanx.takehome.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value="select balance from account where account_id = ?1", nativeQuery = true)
    Optional<BigDecimal> findBalanceByAccountId(Integer accountId);

}
