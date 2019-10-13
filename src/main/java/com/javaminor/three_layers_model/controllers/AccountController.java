package com.javaminor.three_layers_model.controllers;

import com.javaminor.three_layers_model.controllers.dtos.AccountDto;
import com.javaminor.three_layers_model.controllers.mappers.AccountMapper;
import com.javaminor.three_layers_model.services.IAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("account")

public class AccountController {

    private static final int CACHING_TIME = 60;
    private final IAccountService accountService;

    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/{accountId}", produces = "application/json")
    @ApiOperation("Get account by ID")
    public ResponseEntity<AccountDto> getAccount(
            @PathVariable Long accountId
    ) {
        var account = accountService.getAccount(accountId);
        if (account.isPresent()) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(CACHING_TIME, TimeUnit.SECONDS))
                    .body(AccountMapper.INSTANCE.destinationToSource(account.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "", produces = "application/json")
    @ApiOperation("Get all accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        var allAccounts = accountService.getAccounts()
                .stream()
                .map(AccountMapper.INSTANCE::destinationToSource)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(allAccounts);
    }

    @PostMapping(value = "", consumes = "application/json")
    @ApiOperation("Creates a new account")
    public ResponseEntity<?> saveAccount(
            @RequestBody @Valid AccountDto account) {
        var accountToCreate =  AccountMapper.INSTANCE.sourceToDestination(account);
        accountService.saveAccount(accountToCreate);

        UriComponents uriComponents = UriComponentsBuilder.fromPath("/accounts/{id}").buildAndExpand(accountToCreate.getAccountId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "", consumes = "application/json")
    @ApiOperation("Updates an existing account")
    public ResponseEntity<?> updateAccount(
            @RequestBody @Valid AccountDto account) {
        var accountToUpdate =  AccountMapper.INSTANCE.sourceToDestination(account);
        if (accountService.updateAccount(accountToUpdate)) {
            UriComponents uriComponents = UriComponentsBuilder.fromPath("/accounts/{id}").buildAndExpand(accountToUpdate.getAccountId());
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());

            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{accountId}", consumes = "application/json")
    @ApiOperation("Deletes an account")
    public ResponseEntity<?> deleteAccount(
            @PathVariable Long accountId){
        if (accountService.deleteAccount(accountId)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}