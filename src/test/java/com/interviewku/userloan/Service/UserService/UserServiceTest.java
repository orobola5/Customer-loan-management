package com.interviewku.userloan.Service.UserService;

import com.interviewku.userloan.Dto.Request.UserRequest;
import com.interviewku.userloan.Dto.Response.User.UserResponse;
import com.interviewku.userloan.Model.Address;
import com.interviewku.userloan.Model.Gender;
import org.hibernate.type.LocalDateTimeType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {

    }

//    @AfterEach
//    void tearDown() {
//    }

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
    void searchUserByEmail() {
    }

    @Test
    void getAllUser() {
    }

    @Test
    void searchUserByLoan() {
    }
}