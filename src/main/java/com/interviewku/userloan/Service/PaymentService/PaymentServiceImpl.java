package com.interviewku.userloan.Service.PaymentService;

import com.interviewku.userloan.Dto.Response.Payment.PaymentResponse;
import com.interviewku.userloan.Model.Payment;
import com.interviewku.userloan.Repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;


    @Override
    public PaymentResponse payLoan(Payment payments, int loanId) {
        Payment paymentRepositoryLoanById=paymentRepository.findLoanById(loanId);
        if(paymentRepositoryLoanById==null){
            throw new IllegalArgumentException("No one has Apply for this loan");
        }
        paymentRepositoryLoanById.setLoanId(payments.getLoanId());
        Payment payee =paymentRepository.save(paymentRepositoryLoanById);
        PaymentResponse response= new PaymentResponse();
        response.setPayment(payee);
        response.setMessage("payment successful");

        return response;
    }

    @Override
    public PaymentResponse searchPayment(int transactionId) {
        return null;
    }
}
