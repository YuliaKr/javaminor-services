package com.javaminor.three_layers_model.repositories;

import com.javaminor.three_layers_model.repositories.entities.MasterAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterAccountRepository extends JpaRepository<MasterAccount, Long> {
}
