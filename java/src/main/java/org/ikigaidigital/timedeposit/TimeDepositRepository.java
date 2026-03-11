package org.ikigaidigital.timedeposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface TimeDepositRepository
            extends JpaRepository<TimeDeposit, Integer> {
    }


