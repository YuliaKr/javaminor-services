package com.javaminor.three_layers_model.controllers.mappers;

import com.javaminor.three_layers_model.controllers.dtos.SlaveAccountDto;
import com.javaminor.three_layers_model.repositories.entities.SlaveAccount;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-13T19:04:11+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
public class SlaveAccountMapperImpl implements SlaveAccountMapper {

    @Override
    public SlaveAccountDto destinationToSource(SlaveAccount slaveAccount) {
        if ( slaveAccount == null ) {
            return null;
        }

        SlaveAccountDto slaveAccountDto = new SlaveAccountDto();

        slaveAccountDto.setIban( slaveAccount.getIban() );
        slaveAccountDto.setBalance( slaveAccount.getBalance() );

        return slaveAccountDto;
    }

    @Override
    public SlaveAccount sourceToDestination(SlaveAccountDto slaveAccountDto) {
        if ( slaveAccountDto == null ) {
            return null;
        }

        SlaveAccount slaveAccount = new SlaveAccount();

        slaveAccount.setIban( slaveAccountDto.getIban() );
        slaveAccount.setBalance( slaveAccountDto.getBalance() );
        slaveAccount.setAccountNumber( slaveAccountDto.getAccountNumber() );

        return slaveAccount;
    }
}
