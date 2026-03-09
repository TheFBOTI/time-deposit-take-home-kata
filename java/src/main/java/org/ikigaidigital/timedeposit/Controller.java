package org.ikigaidigital;

import java.util.ArrayList;
import java.util.List;

public class controller {
    @RestController
    @RequestMapping("/time-deposits")
    public class TimeDepositController {

        private final List<TimeDeposit> deposits = new ArrayList<>();

        public TimeDepositController() {
            deposits.add(new TimeDeposit(1, "student", 1000.0, 40));
            deposits.add(new TimeDeposit(2, "premium", 5000.0, 60));
            deposits.add(new TimeDeposit(3, "basic", 2000.0, 20));
        }

        @GetMapping("/getalltimedeposits")
        public List<TimeDeposit> getAllTimeDeposits() {
            return deposits;
        }
    }
}
