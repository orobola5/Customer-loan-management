package com.interviewku.userloan.Repository;

import com.interviewku.userloan.Dto.Response.Loan.LoanResponse;
import com.interviewku.userloan.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {

    List<Loan> findAllByAccountNumberAndLoanType(String accountNumber, String loanType);
//    @Query(nativeQuery = true,value = "select * from loan where accountNumber =:accountNumber")
    Loan findByAccountNumber(String accountNumber);
}
