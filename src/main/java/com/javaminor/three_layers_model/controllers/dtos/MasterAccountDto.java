package com.javaminor.three_layers_model.controllers.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MasterAccountDto extends AccountDto {
    @NotNull
    private SlaveAccountDto firstSlaveAccount;

    @NotNull
    private SlaveAccountDto secondSlaveAccount;

}
