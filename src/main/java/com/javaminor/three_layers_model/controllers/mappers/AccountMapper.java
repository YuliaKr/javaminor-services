package com.javaminor.three_layers_model.controllers.mappers;

import com.javaminor.three_layers_model.controllers.dtos.AccountDto;
import com.javaminor.three_layers_model.repositories.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class );
    Account sourceToDestination(AccountDto source);

    @Mapping(target = "accountNumber", ignore = true)
    AccountDto destinationToSource(Account destination);
}