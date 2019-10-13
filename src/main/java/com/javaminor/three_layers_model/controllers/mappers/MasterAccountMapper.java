package com.javaminor.three_layers_model.controllers.mappers;

import com.javaminor.three_layers_model.controllers.dtos.MasterAccountDto;
import com.javaminor.three_layers_model.repositories.entities.MasterAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface MasterAccountMapper {
    MasterAccountMapper INSTANCE = Mappers.getMapper( MasterAccountMapper.class );
    MasterAccount sourceToDestination(MasterAccountDto source);
    MasterAccountDto destinationToSource(MasterAccount destination);
}
