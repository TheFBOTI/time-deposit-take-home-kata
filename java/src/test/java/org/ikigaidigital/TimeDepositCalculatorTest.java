package org.ikigaidigital;

import org.junit.jupiter.api.Test;
import java.util.*;
import  org.ikigaidigital.timedeposit.TimeDeposit;
import org.ikigaidigital.timedeposit.TimeDepositCalculator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;


public class TimeDepositCalculatorTest {
    private final TimeDepositCalculator calc = new TimeDepositCalculator();

    @Test
    public void updateBalance_BasicPlan_CalculatesInterest() {
        // Arrange: 1000 * 0.01 / 12 = 0.83333... -> Round down = 0.83
        TimeDeposit basicPlan = new TimeDeposit(1, "basic", 1000.00, 45);
        List<TimeDeposit> plans = Collections.singletonList(basicPlan);

        // Act
        calc.updateBalance(plans);

        // Assert: 1000.00 + 0.83 = 1000.83
        assertThat(basicPlan.getBalance()).isCloseTo(1000.83, within(0.001));

        // Arrange: 1,234,567.00 * 0.01 / 12 = 1028.8058... -> Round Half Up = 1028.81
        basicPlan = new TimeDeposit(1, "basic",  1234567.00, 45);
        plans = Collections.singletonList(basicPlan);

        // Act
        calc.updateBalance(plans);

        // Assert: 100.00 + 1028.81 = 1235595.81
        assertThat(basicPlan.getBalance()).isCloseTo(1235595.81, within(0.001));
    }

    @Test
    public void updateBalance_StudentPlan_UnderOneYear_CalculateInterest() {
        // Arrange: 1000 * 0.03 / 12 = 2.50
        TimeDeposit student = new TimeDeposit(2, "student", 1000.00, 31);

        // Act
        calc.updateBalance(Collections.singletonList(student));

        // Assert
        assertThat(student.getBalance()).isEqualTo(1002.50);


        // Arrange: 1234567.00.81 * 0.03 / 12 = 2.50
        student = new TimeDeposit(2, "student", 1234567.00, 31);

        // Act
        calc.updateBalance(Collections.singletonList(student));

        // Assert
        assertThat(student.getBalance()).isEqualTo(1237653.42);

    }

    @Test
    public void updateBalance_StudentPlan_OverOneYear_DoNotCalculateInterest() {
        // Arrange: 1000 * 0.03 / 12 = 2.50
        TimeDeposit student = new TimeDeposit(2, "student", 1000.00, 400);

        // Act
        calc.updateBalance(Collections.singletonList(student));

        // Assert
        assertThat(student.getBalance()).isEqualTo(1000.00);


        // Arrange: 1234567.00.81 * 0.03 / 12 = 2.50
        student = new TimeDeposit(2, "student", 1234567.00, 400);

        // Act
        calc.updateBalance(Collections.singletonList(student));

        // Assert
        assertThat(student.getBalance()).isEqualTo(1234567.00);

    }


    @Test
    public void updateBalance_PremiumPlan_Below_FortySixDays_DoNotCalculateInterest() {
        // Premium requires days > 45
        // Arrange
        TimeDeposit premium = new TimeDeposit(3, "premium", 1000.00, 45);

        // Act
        calc.updateBalance(Collections.singletonList(premium));

        // Assert
        assertThat(premium.getBalance()).isEqualTo(1000.00);

        // Arrange
         premium = new TimeDeposit(3, "premium", 1234567.00, 40);

        // Act
        calc.updateBalance(Collections.singletonList(premium));

        // Assert
        assertThat(premium.getBalance()).isEqualTo(1234567.00);
    }

    @Test
    public void updateBalance_PremiumPlan_Over_FortyFiveDays_DoNotCalculateInterest() {
        // Premium requires days > 45
        // Arrange
        TimeDeposit premium = new TimeDeposit(3, "premium", 1000.00, 46);

        // Act
        calc.updateBalance(Collections.singletonList(premium));
        // should return 4.166666666666667 which should be rounded to 4.17

        // Assert
        assertThat(premium.getBalance()).isEqualTo(1004.17);

        // Arrange
        premium = new TimeDeposit(3, "premium", 1234567.00, 46);
        // Should return 5,144.029166666667 - rounded to 5,144.03

        // Act
        calc.updateBalance(Collections.singletonList(premium));

        // Assert
        assertThat(premium.getBalance()).isEqualTo(1239711.03);
    }


    @Test
    public void updateBalance_AnyPlan_UnderThirtyDays_NoInterest() {
        // Logic requires days > 30
        // Arrange
        TimeDeposit basicShortTerm = new TimeDeposit(4, "basic", 1000.00, 20);

        // Act
        calc.updateBalance(Collections.singletonList(basicShortTerm));

        // Assert
        assertThat(basicShortTerm.getBalance()).isEqualTo(1000.00);
    }

}
