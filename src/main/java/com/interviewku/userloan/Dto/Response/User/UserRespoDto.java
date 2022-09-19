package com.interviewku.userloan.Dto.Response.User;

import com.interviewku.userloan.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRespoDto {
    private List<User> responseList;
}
