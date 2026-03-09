package org.ikigaidigital.timedeposit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

public class controller {
    @RestController
    @RequestMapping("/time-deposits")
    public class TimeDepositController {

        private final List<org.ikigaidigital.TimeDeposit> deposits = new ArrayList<>();

        public TimeDepositController() {
            deposits.add(new org.ikigaidigital.TimeDeposit(1, "student", 1000.0, 40));
            deposits.add(new org.ikigaidigital.TimeDeposit(2, "premium", 5000.0, 60));
            deposits.add(new org.ikigaidigital.TimeDeposit(3, "basic", 2000.0, 20));
        }

        @GetMapping("/getalltimedeposits")
        public List<org.ikigaidigital.TimeDeposit> getAllTimeDeposits() {
            return deposits;
        }
    }
}
