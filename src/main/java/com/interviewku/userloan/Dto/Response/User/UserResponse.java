package com.interviewku.userloan.Dto.Response.User;

import com.interviewku.userloan.Model.User;
import lombok.Data;

@Data

public class UserResponse {
    private String message;
    private User user;

}
