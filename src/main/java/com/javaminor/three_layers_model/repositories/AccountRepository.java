package com.javaminor.three_layers_model.repositories;

import com.javaminor.three_layers_model.repositories.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, Long> {
    class MasterAccountRepository {
    }
}
