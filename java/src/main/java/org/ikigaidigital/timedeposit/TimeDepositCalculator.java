package org.ikigaidigital.timedeposit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TimeDepositCalculator {
    //Not  allowed to update method signature - but for readability I would have updated the xs to a different name something generic like
    // ListOfTimeDeposits
    public void updateBalance(List<TimeDeposit> xs) {

        for (TimeDeposit timedeposit : xs) {
            double interest = 0;
            int days = timedeposit.getDays();
            double balance = timedeposit.getBalance();

            if (days > 30) {
                switch (timedeposit.getPlanType().toLowerCase()) {
                    case "basic":
                        interest = balance * 0.01 / 12;
                        break;

                    case "student":
                        // Probably should confirm in reality - is a year 365, or does it change on a leap year.
                        // as an upgrade we could add ActiveDate on the TimeDeposit object which would allow us to use LocalDate time to add a year (which accounts for the leap year)
                        if (days <= 365) {
                            interest = balance * 0.03 / 12;
                        }
                        break;

                    case "premium":
                        if (days > 45) {
                            interest = balance * 0.05 / 12;
                        }
                        break;
                }
            }
            double a2d = timedeposit.getBalance() + (new BigDecimal(interest).setScale(2, RoundingMode.HALF_UP)).doubleValue();
            timedeposit.setBalance(a2d);
        }
    }

}
