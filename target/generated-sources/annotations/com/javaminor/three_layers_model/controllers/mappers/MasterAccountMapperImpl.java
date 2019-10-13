package com.javaminor.three_layers_model.controllers.mappers;

import com.javaminor.three_layers_model.controllers.dtos.MasterAccountDto;
import com.javaminor.three_layers_model.controllers.dtos.SlaveAccountDto;
import com.javaminor.three_layers_model.repositories.entities.MasterAccount;
import com.javaminor.three_layers_model.repositories.entities.SlaveAccount;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-13T19:04:12+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
public class MasterAccountMapperImpl implements MasterAccountMapper {

    @Override
    public MasterAccount sourceToDestination(MasterAccountDto source) {
        if ( source == null ) {
            return null;
        }

        MasterAccount masterAccount = new MasterAccount();

        masterAccount.setIban( source.getIban() );
        masterAccount.setBalance( source.getBalance() );
        masterAccount.setAccountNumber( source.getAccountNumber() );
        masterAccount.setFirstSlaveAccount( slaveAccountDtoToSlaveAccount( source.getFirstSlaveAccount() ) );
        masterAccount.setSecondSlaveAccount( slaveAccountDtoToSlaveAccount( source.getSecondSlaveAccount() ) );

        return masterAccount;
    }

    @Override
    public MasterAccountDto destinationToSource(MasterAccount destination) {
        if ( destination == null ) {
            return null;
        }

        MasterAccountDto masterAccountDto = new MasterAccountDto();

        masterAccountDto.setIban( destination.getIban() );
        masterAccountDto.setBalance( destination.getBalance() );
        masterAccountDto.setFirstSlaveAccount( slaveAccountToSlaveAccountDto( destination.getFirstSlaveAccount() ) );
        masterAccountDto.setSecondSlaveAccount( slaveAccountToSlaveAccountDto( destination.getSecondSlaveAccount() ) );

        return masterAccountDto;
    }

    protected SlaveAccount slaveAccountDtoToSlaveAccount(SlaveAccountDto slaveAccountDto) {
        if ( slaveAccountDto == null ) {
            return null;
        }

        SlaveAccount slaveAccount = new SlaveAccount();

        slaveAccount.setIban( slaveAccountDto.getIban() );
        slaveAccount.setBalance( slaveAccountDto.getBalance() );
        slaveAccount.setAccountNumber( slaveAccountDto.getAccountNumber() );

        return slaveAccount;
    }

    protected SlaveAccountDto slaveAccountToSlaveAccountDto(SlaveAccount slaveAccount) {
        if ( slaveAccount == null ) {
            return null;
        }

        SlaveAccountDto slaveAccountDto = new SlaveAccountDto();

        slaveAccountDto.setIban( slaveAccount.getIban() );
        slaveAccountDto.setBalance( slaveAccount.getBalance() );

        return slaveAccountDto;
    }
}
