package com.javaminor.three_layers_model.controllers.mappers;

import com.javaminor.three_layers_model.controllers.dtos.AccountDto;
import com.javaminor.three_layers_model.repositories.entities.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountMapperTest {
    @Test
    public void shouldMapAccountToDto() {
        //given
        Account account = new Account();
        account.setBalance(100.00);
        account.setAccountNumber("12345678");
        account.setIban("12345678");
        //when
        AccountDto accountDto = AccountMapper.INSTANCE.destinationToSource(account);

        //then
        Assert.assertEquals(account.getBalance(), accountDto.getBalance());
        Assert.assertEquals("NL00TEST" + account.getAccountNumber(), accountDto.getIban());
        Assert.assertEquals(account.getIban(), accountDto.getIban());
    }
}
