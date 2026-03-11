package org.ikigaidigital.timedeposit;

import org.springframework.web.bind.annotation.GetMapping;
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
}