package com.interviewku.userloan.Service.PaymentService;

import com.interviewku.userloan.Dto.Response.Payment.PaymentResponse;
import com.interviewku.userloan.Model.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

     PaymentResponse payLoan(Payment payments, int loanId);
     PaymentResponse searchPayment(int transactionId);

}
