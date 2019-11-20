package com.javaminor.three_layers_model.controllers.mappers;

import com.javaminor.three_layers_model.controllers.dtos.SlaveAccountDto;
import com.javaminor.three_layers_model.repositories.entities.SlaveAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface SlaveAccountMapper {

   SlaveAccountMapper INSTANCE = Mappers.getMapper( SlaveAccountMapper.class );

   SlaveAccountDto destinationToSource(SlaveAccount slaveAccount);

   SlaveAccount sourceToDestination(SlaveAccountDto slaveAccountDto);
}
