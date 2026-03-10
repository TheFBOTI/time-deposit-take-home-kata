package org.ikigaidigital.timedeposit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time-deposits")
public class Controller {

    private final List<TimeDeposit> deposits = new ArrayList<>();

    public Controller() {
        deposits.add(new TimeDeposit(1, "student", 1000.0, 40));
        deposits.add(new TimeDeposit(2, "premium", 5000.0, 60));
        deposits.add(new TimeDeposit(3, "basic", 2000.0, 20));
    }

    @GetMapping("/getalltimedeposits")
    public List<TimeDeposit> getAllTimeDeposits() {
        return deposits;
    }
}