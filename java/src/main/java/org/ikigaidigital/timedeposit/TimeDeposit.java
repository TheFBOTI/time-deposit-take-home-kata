package org.ikigaidigital.timedeposit;

import jakarta.persistence.*;

@Entity
@Table(name = "time_deposits")
public class TimeDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String planType;
    @Column(nullable = false)
    private Double balance;
    @Column(nullable = false)
    private int days;

    // TODO add withdrawals

    public TimeDeposit(int id, String planType, Double balance, int days) {
        this.id = id;
        this.planType = planType;
        this.balance = balance;
        this.days = days;
    }

    public int getId() { return id; }

    public String getPlanType() {
        return planType;
    }

    public Double getBalance() {
        return balance;
    }

    public int getDays() {
        return days;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
