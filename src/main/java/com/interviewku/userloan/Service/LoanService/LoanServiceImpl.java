package com.interviewku.userloan.Service.LoanService;

import com.interviewku.userloan.Dto.Request.LoanRequest;
import com.interviewku.userloan.Dto.Response.Loan.LoanDto;
import com.interviewku.userloan.Dto.Response.Loan.LoanResponse;
import com.interviewku.userloan.Model.Loan;
import com.interviewku.userloan.Repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    @Override
    public LoanDto createLoan(LoanRequest loanRequest) {
        LoanDto dto=new LoanDto();
        List<Loan> existingLoan=loanRepository.findAllByAccountNumberAndLoanType(loanRequest.getAccountNumber(),loanRequest.getLoanType());
        if(!existingLoan.isEmpty()){
            dto.setMessage("You have already applied for this loan");
           return dto;
        }
        Loan newLoan=new Loan();
        newLoan.setLoanId(loanRequest.getLoanId());
        newLoan.setLoanStartDate(loanRequest.getLoanStartDate());
        newLoan.setLoanAmount(loanRequest.getLoanAmount());
        newLoan.setLoanBalance(loanRequest.getLoanBalance());
        newLoan.setLoanType(loanRequest.getLoanType());
        newLoan.setAccountNumber(loanRequest.getAccountNumber());
        newLoan.setInterestRate(loanRequest.getInterestRate());
        newLoan.setUser(loanRequest.getUser());
        Loan savedLoan=loanRepository.save(newLoan);
        dto.setLoan(savedLoan);
        dto.setMessage("You have successfully  apply for this loan");
        return dto;
    }

    @Override
    public Loan searchLoan(String accountNumber) {
        return loanRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public LoanDto approveLoan(int loanId, String loanType) {
        LoanDto response= new LoanDto();
        Loan existingLoan=loanRepository.findLoanByLoanIdAndLoanType(loanId,loanType);
        if (existingLoan==null){
            response.setMessage("Error approving the Loan");
        }
        else {
            loanRepository.approveLoan(loanId);
            response.setMessage("Loan approved successfully");

        }
        return response;
    }
}
