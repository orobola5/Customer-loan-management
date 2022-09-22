package com.interviewku.userloan.Controller;

import com.interviewku.userloan.Dto.Request.LoanRequest;
import com.interviewku.userloan.Dto.Request.UserRequest;
import com.interviewku.userloan.Dto.Response.Loan.LoanDto;
import com.interviewku.userloan.Dto.Response.Payment.PaymentResponse;
import com.interviewku.userloan.Dto.Response.User.UserRespoDto;
import com.interviewku.userloan.Dto.Response.User.UserResponse;
import com.interviewku.userloan.Model.Loan;
import com.interviewku.userloan.Model.Payment;
import com.interviewku.userloan.Model.User;
import com.interviewku.userloan.Service.LoanService.LoanService;
import com.interviewku.userloan.Service.PaymentService.PaymentService;
import com.interviewku.userloan.Service.UserService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class UserLoanController {

    private final UserService userService;
    private final LoanService loanService;
    private final PaymentService paymentService;

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public UserResponse createUser(@RequestBody UserRequest request){
        return userService.createUser(request);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/email/{email}")
    public User findUserByEmail(@PathVariable String email){
        return userService.searchUserByEmail(email);
    }

    @RequestMapping(method = RequestMethod.GET)
    public UserRespoDto findAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/loan")
    public LoanDto createLoan(@RequestBody LoanRequest request){
        return loanService.createLoan(request);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/accountNumber/{accountNumber}")
    public Loan findLoan(@PathVariable String accountNumber){
        return loanService.searchLoan(accountNumber);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/loanId/{loanId}/{loanType}")
    public LoanDto approveLoan(@PathVariable int loanId, @PathVariable String loanType){
        return loanService.approveLoan(loanId,loanType);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/pay/{loanId}")
    public PaymentResponse payLoan(@RequestBody Payment payment,@PathVariable int loanId){
        return paymentService.payLoan(payment,loanId);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/paymentId")
    public PaymentResponse findPayment(@PathVariable("/id") int paymentId){
        return paymentService.searchPayment(paymentId);
    }










}
