package com.interviewku.userloan.Service.LoanService;

import com.interviewku.userloan.Dto.Request.LoanRequest;
import com.interviewku.userloan.Dto.Response.Loan.LoanDto;
import com.interviewku.userloan.Dto.Response.Loan.LoanResponse;
import com.interviewku.userloan.Model.Loan;
import org.springframework.stereotype.Service;

@Service
public interface LoanService {
     LoanDto createLoan(LoanRequest loanRequest);
     Loan searchLoan(String accountNumber);
     LoanResponse approveLoan(int loanId);
}
