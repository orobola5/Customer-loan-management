package com.interviewku.userloan.Dto.Response.Loan;

import com.interviewku.userloan.Model.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class LoanDto {
    private String message;
    private Loan loan;
}
