package com.javaminor.three_layers_model.repositories.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "slaveAccount")
@Table(name="slaveAccount")
@Getter
@Setter
public class SlaveAccount extends Account{

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    private MasterAccount masterAccount;

    public MasterAccount getMasterAccount() {
        return masterAccount;
    }

    public void setMasterAccount(MasterAccount masterAccount) {
        this.masterAccount = masterAccount;
    }
}


