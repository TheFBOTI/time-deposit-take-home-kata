package org.ikigaidigital.timedeposit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class WithdrawalsRepository {

    public interface WithdrawalRepository extends JpaRepository<Withdrawal, Integer> {

        List<Withdrawal> findByTimeDepositId(Integer timeDepositId);

    }

}
