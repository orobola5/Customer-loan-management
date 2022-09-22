package com.interviewku.userloan.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "loan_id")
    private int loanId;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_amount")
    private float paymentAmount;


}
