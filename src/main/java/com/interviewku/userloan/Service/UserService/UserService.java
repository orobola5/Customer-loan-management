package com.interviewku.userloan.Service.UserService;

import com.interviewku.userloan.Dto.Request.UserRequest;
import com.interviewku.userloan.Dto.Response.User.UserResponse;
import com.interviewku.userloan.Model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserResponse createUser(UserRequest request);
    List<UserResponse> searchUserByEmail(String email);
    UserResponse getAllUser();
    List<UserResponse> searchUserByLoan(Loan loan);




}
