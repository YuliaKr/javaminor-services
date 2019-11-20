package com.javaminor.three_layers_model.services;

import com.javaminor.three_layers_model.repositories.AccountRepository;
import com.javaminor.three_layers_model.repositories.MasterAccountRepository;
import com.javaminor.three_layers_model.repositories.SlaveAccountRepository;
import com.javaminor.three_layers_model.repositories.entities.Account;
import com.javaminor.three_layers_model.repositories.entities.MasterAccount;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;
    private final SlaveAccountRepository slaveAccountRepository;
    private final MasterAccountRepository masterAccountRepository;

    public AccountService(AccountRepository accountRepository, SlaveAccountRepository slaveAccountRepository, MasterAccountRepository masterAccountRepository) {
        this.accountRepository = accountRepository;
        this.slaveAccountRepository = slaveAccountRepository;
        this.masterAccountRepository = masterAccountRepository;
    }

    @Override
    @Cacheable("accounts")
    public Collection<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Cacheable("account")
    public Optional<Account> getAccount(Long accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    @CacheEvict(value = "accounts", allEntries = true)
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    @Cacheable("masterAccount")
    public List<MasterAccount> getAllMasterAccounts() {
        return masterAccountRepository.findAll();
    }

    @Override
    @CacheEvict(value = "accounts", allEntries = true)
    public Boolean deleteAccount(Long accountId) {

        var existingAccount = accountRepository.findById(accountId);
        if (existingAccount.isPresent()) {
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }

    @Override
    @CachePut(value="accounts", key = "account.accountId")
    public Boolean updateAccount(@Valid Account account) {
        var accountToUpdate = accountRepository.findById(account.getAccountId());
        if (accountToUpdate.isPresent()) {
            var dbAccount = accountToUpdate.get();
            dbAccount.setAccountNumber(account.getAccountNumber());
            dbAccount.setBalance(account.getBalance());
            accountRepository.save(dbAccount);
            return true;
        }
        return false;
    }

    @Override
    public void saveAccount(@Valid MasterAccount masterAccount) {
        masterAccountRepository.save(masterAccount);
    }
}