package com.javaminor.three_layers_model.repositories.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "masterAccount")
@Table(name="masterAccount")
@Getter
@Setter
public class MasterAccount extends Account{
    @NotNull
    @OneToOne(fetch = FetchType.EAGER, optional = false, mappedBy = "masterAccount", cascade = CascadeType.ALL)
    @JoinColumn(name="firstSubAccountId")
    private SlaveAccount firstSlaveAccount;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, optional = false, mappedBy = "masterAccount", cascade = CascadeType.ALL)
    @JoinColumn(name="secondSubAccountId")
    private SlaveAccount secondSlaveAccount;

    public SlaveAccount getFirstSlaveAccount() {
        return firstSlaveAccount;
    }

    public SlaveAccount getSecondSlaveAccount() {
        return secondSlaveAccount;
    }

    public void setFirstSlaveAccount(SlaveAccount firstSlaveAccount) {
        this.firstSlaveAccount = firstSlaveAccount;
    }

    public void setSecondSlaveAccount(SlaveAccount secondSlaveAccount) {
        this.secondSlaveAccount = secondSlaveAccount;
    }
}
