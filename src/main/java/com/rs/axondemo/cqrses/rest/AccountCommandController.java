package com.rs.axondemo.cqrses.rest;

import com.rs.axondemo.cqrses.entity.BankAccount;
import com.rs.axondemo.cqrses.rest.dto.AccountCreationDTO;
import com.rs.axondemo.cqrses.rest.dto.MoneyAmountDTO;
import com.rs.axondemo.cqrses.service.AccountCommandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/accounts")
@AllArgsConstructor
public class AccountCommandController {
    private final AccountCommandService accountCommandService;

    @PostMapping
    @ResponseStatus(value = CREATED)
    public CompletableFuture<BankAccount> createAccount(@RequestBody AccountCreationDTO creationDTO) {
        return this.accountCommandService.createAccount(creationDTO);
    }

    @PutMapping(value = "/credit/{accountId}")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountId") String accountId,
                                                          @RequestBody MoneyAmountDTO moneyCreditDTO) {
        return this.accountCommandService.creditMoneyToAccount(accountId, moneyCreditDTO);
    }
//
//    @PutMapping(value = "/debit/{accountId}")
//    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountId") String accountId,
//                                                           @RequestBody MoneyAmountDTO moneyDebitDTO) {
//        return this.accountCommandService.debitMoneyFromAccount(accountId, moneyDebitDTO);
//    }
}
