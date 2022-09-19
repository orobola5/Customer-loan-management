package com.interviewku.userloan.Service.UserService;

import com.interviewku.userloan.Dto.Request.UserRequest;
import com.interviewku.userloan.Dto.Response.User.UserCreateResponse;
import com.interviewku.userloan.Dto.Response.User.UserRespoDto;
import com.interviewku.userloan.Dto.Response.User.UserResponse;
import com.interviewku.userloan.Model.Loan;
import com.interviewku.userloan.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserResponse createUser(UserRequest request);
    User searchUserByEmail(String email);
    UserRespoDto getAllUser();
    UserResponse searchUserByLoan(Loan loan);




}
