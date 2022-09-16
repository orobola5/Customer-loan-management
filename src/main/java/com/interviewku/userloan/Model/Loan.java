package com.interviewku.userloan.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "loan_table")
public class Loan {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;

    @Column(name = "loan_amount")
    private float loanAmount;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "trade_date")
    private Date tradeDate = new Date(System.currentTimeMillis());

    @Temporal(value = TemporalType.DATE)
    @Column(name = "loan_start_date", columnDefinition = "date")
    private Date loanStartDate;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "loan_maturity_date")
    private Date loanMaturityDate;

    @Column(name = "payment_frequency")
    private String paymentFrequency;

    @Column(name = "interest_rate")
    private float interestRate;

    @ManyToOne()
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> payment;
}
