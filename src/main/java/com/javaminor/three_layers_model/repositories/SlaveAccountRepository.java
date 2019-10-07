package com.javaminor.three_layers_model.repositories;

import com.javaminor.three_layers_model.repositories.entities.SlaveAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlaveAccountRepository extends JpaRepository<SlaveAccount, Long> {
}
