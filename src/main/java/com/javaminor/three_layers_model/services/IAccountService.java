package com.javaminor.three_layers_model.services;

import com.javaminor.three_layers_model.repositories.entities.Account;
import com.javaminor.three_layers_model.repositories.entities.MasterAccount;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IAccountService {

    Collection<Account> getAccounts();

    Optional<Account> getAccount(Long accountId);

    void saveAccount(Account account);

    List<MasterAccount> getAllMasterAccounts();

    Boolean deleteAccount(Long accountId);

    Boolean updateAccount(Account account);

    void saveAccount(MasterAccount masterAccount);
}
