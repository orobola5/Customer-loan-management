package com.interviewku.userloan.Dto.Response.User;

import com.interviewku.userloan.Model.Address;
import com.interviewku.userloan.Model.Gender;
import com.interviewku.userloan.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDateTime dateOfBirth;
    private String email;
    private String password;
    private String phoneNumber;
    private String accountNumber;
    private Address address;
}
