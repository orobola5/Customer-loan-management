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
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "loan_type")
    private String loanType;
    @Column(name = "loan_amount")
    private float loanAmount;
    @Column(name = "loan_balance")
    private float loanBalance;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "loan_start_date", columnDefinition = "date")
    private Date loanStartDate;
    @Column(name = "interest_rate")
    private float interestRate;
    @ManyToOne
    private User user;

    private String loanStatus;
    private String paymentStatus;



}
