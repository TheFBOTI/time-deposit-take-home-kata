package org.ikigaidigital.timedeposit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time-deposits")
public class Controller {

    private final TimeDepositRepository timeDepositRepository;
    public Controller(TimeDepositRepository timeDepositRepository) {
        this.timeDepositRepository = timeDepositRepository;
    }

    @GetMapping("/getalltimedeposits")
    public List<TimeDeposit> getAllTimeDeposits() {
        return timeDepositRepository.findAll();
    }

    @PostMapping("/updatebalances")
    public List<TimeDeposit> updateAllBalances() {
        // Get all time deposit objects
        List<TimeDeposit> deposits = timeDepositRepository.findAll();

        // iterate over them with for Each, rather than a generic for loop - as we don't need to break out of this as the READMe says update all balances
        deposits.forEach(deposit -> deposit.setBalance(deposit.getBalance() * 1.50));

        //Save 'em
        return timeDepositRepository.saveAll(deposits);
    }

}