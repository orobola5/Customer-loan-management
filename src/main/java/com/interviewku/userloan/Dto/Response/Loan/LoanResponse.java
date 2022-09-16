package com.interviewku.userloan.Dto.Response.Loan;

import com.interviewku.userloan.Model.Loan;
import lombok.Data;

import java.util.List;
@Data
public class LoanResponse {
    private List<Loan> loanList;
}
