package org.ikigaidigital.timedeposit;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "\"withdrawals\"")
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "timeDepositId", nullable = false)
    @JsonBackReference
    private TimeDeposit timeDeposit;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private LocalDate date;

    public Withdrawal() {
    }

    public Integer getId() {
        return id;
    }

    public TimeDeposit getTimeDeposit() {
        return timeDeposit;
    }

    public void setTimeDeposit(TimeDeposit timeDeposit) {
        this.timeDeposit = timeDeposit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
