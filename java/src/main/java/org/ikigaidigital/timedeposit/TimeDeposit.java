package org.ikigaidigital.timedeposit;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"timeDeposits\"")
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

    @OneToMany(mappedBy = "timeDeposit", cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<Withdrawal> withdrawals;

    public TimeDeposit(int id, String planType, Double balance, int days) {
        this.id = id;
        this.planType = planType;
        this.balance = balance;
        this.days = days;
    }
    // ✅ No-args constructor required by JPA
    public TimeDeposit() {}

    public int getId() {
        return id;
    }

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

    public List<Withdrawal> getWithdrawals() {
        return withdrawals;
    }

}
