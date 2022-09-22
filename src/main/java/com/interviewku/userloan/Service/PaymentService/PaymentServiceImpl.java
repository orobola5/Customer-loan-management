package com.interviewku.userloan.Service.PaymentService;

import com.interviewku.userloan.Dto.Response.Payment.PaymentResponse;
import com.interviewku.userloan.Model.Loan;
import com.interviewku.userloan.Model.Payment;
import com.interviewku.userloan.Repository.LoanRepository;
import com.interviewku.userloan.Repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Date;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    private final LoanRepository loanRepository;


    @Override
    public PaymentResponse payLoan(Payment payments, int loanId) {
        PaymentResponse response= new PaymentResponse();
        Loan existingLoan=loanRepository.findLoanByLoanId(loanId);
        if(existingLoan==null){
            throw new IllegalArgumentException("No one has Apply for this loan");
        } else  {
            float balance=existingLoan.getLoanBalance();
            if(balance==0){
                throw new IllegalArgumentException("loan is already cleared");
            } else if (payments.getPaymentAmount()>=balance) {
             payments.setPaymentDate(Date.from(Instant.now()));
             payments.setLoanId(loanId);
             paymentRepository.save(payments);
             loanRepository.updateLoanBalance(loanId,payments.getPaymentAmount());
             loanRepository.updateFullPaymentStatus(payments.getPaymentStatus());
                response.setPayment(payments);
                response.setMessage("payment successful");
            }
            else {
                payments.setPaymentDate(Date.from(Instant.now()));
                payments.setLoanId(loanId);
                paymentRepository.save(payments);
                loanRepository.updateLoanBalance(loanId,payments.getPaymentAmount());
                loanRepository.updatePartialPaymentStatus(payments.getPaymentStatus());
                response.setPayment(payments);
                response.setMessage("partial payment successful");
            }

        }

        return response;
    }

    @Override
    public PaymentResponse searchPayment(int paymentId) {
        PaymentResponse apiResponse = new PaymentResponse();
        Payment existingPayment = paymentRepository.findPaymentByPaymentId(paymentId);
        if (existingPayment == null) {
            apiResponse.setMessage("Payment details not found");
        } else {

            apiResponse.setMessage("success");
            apiResponse.setPayment(existingPayment);
        }
        return apiResponse;
    }
}
