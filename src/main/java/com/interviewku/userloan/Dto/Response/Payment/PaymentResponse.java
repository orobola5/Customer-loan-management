package com.interviewku.userloan.Dto.Response.Payment;

import com.interviewku.userloan.Model.Payment;
import lombok.Data;

@Data
public class PaymentResponse {
    private String message;
    private Payment payment;
}
