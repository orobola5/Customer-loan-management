package com.interviewku.userloan.Repository;

import com.interviewku.userloan.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    @Query(nativeQuery = true,value = "select * from payment where loanId =:loanId ")
    Payment findLoanById(int loanId);

}
