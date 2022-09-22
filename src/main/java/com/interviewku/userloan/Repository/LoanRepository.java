package com.interviewku.userloan.Repository;

import com.interviewku.userloan.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {

    List<Loan> findAllByAccountNumberAndLoanType(String accountNumber, String loanType);
   @Query(nativeQuery = true,value = "select * from loan where account_number =:accountNumber")
    Loan findByAccountNumber(String accountNumber);

    @Query(nativeQuery = true,value = "select * from loan where loan_id =:loanId ")
    Loan findLoanByLoanId(int loanId);
    @Transactional
    @Modifying
    @Query(value = "update loan set loan_balance=loan_balance -:paymentAmount where loan_id=:loanId",nativeQuery = true)
    void updateLoanBalance(int loanId, float paymentAmount);

    @Transactional
    @Modifying
    @Query(value = "update loan set payment_status='Paid' where loan_id=:loanId",nativeQuery = true)
    void updateFullPaymentStatus(String loanId);

    @Transactional
    @Modifying
    @Query(value = "update loan set payment_status='PartiallyPaid' where loan_id=:loanId",nativeQuery = true)
    void updatePartialPaymentStatus(String loanId);

    @Transactional
    @Modifying
    @Query(value = "update loan set loan_status='Approved',loan_balance=loan_amount where loan_id=:loanId",nativeQuery = true)
    void approveLoan(int loanId);
    Loan findLoanByLoanIdAndLoanType(int loanId,String loanType);


}
