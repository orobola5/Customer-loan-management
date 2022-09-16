package com.interviewku.userloan.Service.LoanService;

import com.interviewku.userloan.Dto.Response.Loan.LoanResponse;
import com.interviewku.userloan.Model.Loan;
import org.springframework.stereotype.Service;

@Service
public interface LoanService {
     LoanResponse createLoan(Loan loans);
     LoanResponse searchLoan(String accountNumber);
     LoanResponse approveLoan(int loanId);
}
