package com.interviewku.userloan.Dto.Request;

import com.interviewku.userloan.Model.Payment;
import com.interviewku.userloan.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private int loanId;
    private String accountNumber;
    private String loanType;
    private float loanAmount;
    private float loanBalance;
    private Date loanStartDate;
    private String paymentFrequency;
    private float interestRate;
    private User user;
    private List<Payment> payment;
}
