package com.javaminor.three_layers_model.controllers.mappers;

import com.javaminor.three_layers_model.controllers.dtos.AccountDto;
import com.javaminor.three_layers_model.repositories.entities.Account;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-13T19:04:11+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account sourceToDestination(AccountDto source) {
        if ( source == null ) {
            return null;
        }

        Account account = new Account();

        account.setIban( source.getIban() );
        account.setBalance( source.getBalance() );
        account.setAccountNumber( source.getAccountNumber() );

        return account;
    }

    @Override
    public AccountDto destinationToSource(Account destination) {
        if ( destination == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setIban( destination.getIban() );
        accountDto.setBalance( destination.getBalance() );

        return accountDto;
    }
}
