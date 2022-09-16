package com.interviewku.userloan.Dto.Request;

import com.interviewku.userloan.Model.Address;
import com.interviewku.userloan.Model.Gender;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
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
