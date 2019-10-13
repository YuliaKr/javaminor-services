package com.javaminor.three_layers_model.controllers;

import com.javaminor.three_layers_model.controllers.dtos.MasterAccountDto;
import com.javaminor.three_layers_model.controllers.mappers.MasterAccountMapper;
import com.javaminor.three_layers_model.repositories.entities.MasterAccount;
import com.javaminor.three_layers_model.services.IAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("masterAccount")
public class MasterAccountController {
    private final IAccountService accountService;

    @Autowired
    public MasterAccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "", consumes = "application/json")
    @ApiOperation("Creates a new master account")
    public ResponseEntity<?> saveCombiAccount(
            @RequestBody @Valid MasterAccountDto masterAccount) {
        MasterAccount toCreate =  MasterAccountMapper.INSTANCE.sourceToDestination(masterAccount);
        accountService.saveAccount(toCreate);

        UriComponents uriComponents = UriComponentsBuilder.fromPath("/account/{id}").buildAndExpand(toCreate.getAccountId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "", produces = "application/json")
    @ApiOperation("Returns all master accounts from the database")
    public ResponseEntity<List<MasterAccountDto>> getAllAccounts() {
        var allAccounts = accountService.getAllMasterAccounts()
                .stream()
                .map(MasterAccountMapper.INSTANCE::destinationToSource)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(allAccounts);
    }
}
