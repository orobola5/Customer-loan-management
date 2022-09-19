package com.interviewku.userloan.Service.UserService;

import com.interviewku.userloan.Dto.Request.LoanRequest;
import com.interviewku.userloan.Dto.Request.UserRequest;
import com.interviewku.userloan.Dto.Response.Loan.LoanDto;
import com.interviewku.userloan.Dto.Response.Loan.LoanResponse;
import com.interviewku.userloan.Dto.Response.Payment.PaymentResponse;
import com.interviewku.userloan.Dto.Response.User.UserRespoDto;
import com.interviewku.userloan.Dto.Response.User.UserResponse;
import com.interviewku.userloan.Model.*;

import com.interviewku.userloan.Repository.PaymentRepository;
import com.interviewku.userloan.Service.LoanService.LoanService;
import com.interviewku.userloan.Service.PaymentService.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    LoanService loanService;

    @Autowired
    PaymentService paymentService;

    @BeforeEach
    void setUp() {
        Address address=Address.builder()
                .city("Akure")
                .houseNumber(45)
                .zipCode("3245")
                .street("Akinola")
                .state("Ondo State")
                .build();

        UserRequest request =new UserRequest();
        request.setFirstName("Adedayo");
        request.setLastName("Bobby");
        request.setDateOfBirth(LocalDateTime.now());
        request.setGender(Gender.MALE);
        request.setPhoneNumber("08036787853");
        request.setEmail("Adedayo@gmail.com");
        request.setPassword("1234");
        request.setAccountNumber("012890");
        request.setAddress(address);

        UserResponse response=userService.createUser(request);


        Address address2=Address.builder()
                .city("Lagos")
                .houseNumber(25)
                .zipCode("45362")
                .street("Bariga Street")
                .state("Lagos State")
                .build();

        UserRequest request2 =new UserRequest();
        request2.setFirstName("Queen");
        request2.setLastName("Lilly");
        request2.setDateOfBirth(LocalDateTime.now());
        request2.setGender(Gender.FEMALE);
        request2.setPhoneNumber("08066787853");
        request2.setEmail("Queen@gmail.com");
        request2.setPassword("567845");
        request2.setAccountNumber("0145678");
        request2.setAddress(address2);

        UserResponse response2=userService.createUser(request2);

    }



    @Test
    @DisplayName("test that user can be created")
    void createUser() {
        Address address=Address.builder()
                .city("Lagos")
                .houseNumber(2)
                .zipCode("322442")
                .street("Emily Akinola")
                .state("Lagos State")
                .build();

      UserRequest request =new UserRequest();
      request.setFirstName("Dove");
      request.setLastName("Hilly");
      request.setDateOfBirth(LocalDateTime.now());
      request.setGender(Gender.FEMALE);
      request.setPhoneNumber("08056787853");
      request.setEmail("dove@gmail.com");
      request.setPassword("5678");
      request.setAccountNumber("012345");
      request.setAddress(address);

      UserResponse response=userService.createUser(request);
      assertEquals("user is created",response.getMessage());

    }

    @Test
    @DisplayName("test that users can be searched by their email")
    void searchUserByEmail() {
        User users=userService.searchUserByEmail("dove@gmail.com");
        assertEquals("dove@gmail.com",users.getEmail());
    }

    @Test
    void getAllUser() {
        UserRespoDto allUser=userService.getAllUser();
        assertEquals(3,allUser.getResponseList().size());
    }

    @Test
    @DisplayName("test that loan can be created")
    void creatLoan() {
        User user=new User();
        user.setUserId(1l);
        LoanRequest loans =new LoanRequest();
        loans.setLoanId(1);
        loans.setUser(user);
        loans.setLoanType("business");
        loans.setAccountNumber("012345");
        loans.setLoanBalance(150000);
        loans.setLoanAmount(2000000);
        loans.setLoanStartDate(Date.from(Instant.now()));
        loans.setPayment(null);
        loans.setPaymentFrequency(null);
        loans.setInterestRate(2);
        LoanDto savedLoan=loanService.createLoan(loans);
        assertEquals("You have successfully  apply for this loan",savedLoan.getMessage());

        User user2=new User();
        user.setUserId(2l);
        LoanRequest loan2 =new LoanRequest();
        loan2.setLoanId(1);
        loan2.setUser(user2);
        loan2.setLoanType("business");
        loan2.setAccountNumber("01235");
        loan2.setLoanBalance(150000);
        loan2.setLoanAmount(2000000);
        loan2.setLoanStartDate(Date.from(Instant.now()));
        loan2.setPayment(null);
        loan2.setPaymentFrequency(null);
        loan2.setInterestRate(2);
        LoanDto savedLoan2=loanService.createLoan(loan2);
        assertEquals("You have successfully  apply for this loan",savedLoan2.getMessage());
    }

    @Test
    @DisplayName("test that user can search for loan")
    void testThatUserCanSearchForLoan(){
        Loan loan=loanService.searchLoan("012345");
        assertEquals("012345",loan.getAccountNumber());

    }
    @Test
    @DisplayName("test that loan can be paid")
    void testThatUserCanBePaid(){
      Payment loanPayment=new Payment();
      loanPayment.setLoanId(2);
      loanPayment.setPaymentId(1);
      loanPayment.setPaymentDate(Date.from(Instant.now()));
      loanPayment.setPaymentAmount(100000);
      PaymentResponse response=paymentService.payLoan(loanPayment,2);
      assertEquals("payment successful",response.getMessage());
    }



}