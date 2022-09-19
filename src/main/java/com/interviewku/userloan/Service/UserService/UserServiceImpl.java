package com.interviewku.userloan.Service.UserService;

import com.interviewku.userloan.Dto.Request.UserRequest;
import com.interviewku.userloan.Dto.Response.User.UserCreateResponse;
import com.interviewku.userloan.Dto.Response.User.UserRespoDto;
import com.interviewku.userloan.Dto.Response.User.UserResponse;

import com.interviewku.userloan.Model.Loan;
import com.interviewku.userloan.Model.User;
import com.interviewku.userloan.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
@Configuration
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserResponse createUser(UserRequest request) {
        UserResponse apiResponse= new UserResponse();
        List<User> existingUser= userRepository.findAllByEmail(request.getEmail());
        if(!existingUser.isEmpty()){
            apiResponse.setMessage("Email"+request.getEmail()+"already exist");
            return apiResponse;
        }
        User user=new User();
        user.setUserId(request.getUserId());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setPhoneNumber(request.getPhoneNumber());
        String encodedPassword= bCryptPasswordEncoder
                .encode(request.getPassword());
        user.setPassword(encodedPassword);
        user.setAccountNumber(request.getAccountNumber());
        user.setAddress(request.getAddress());
        User registeredUser=userRepository.save(user);
        apiResponse.setUser(registeredUser);
        apiResponse.setMessage("user is created");
        return apiResponse;
    }

    @Override
    public User searchUserByEmail(String email) {

        return userRepository.findByEmail(email);

    }

    @Override
    public UserRespoDto getAllUser() {
        List<User> userList = new ArrayList<>(userRepository.findAll());
        if(userList.isEmpty()){
            throw new IllegalArgumentException("user list is empty");
        }
        UserRespoDto respoDto=new UserRespoDto();
        respoDto.setResponseList(userList);
        return respoDto;

    }



    @Override
    public UserResponse searchUserByLoan(Loan loan) {

        return null;
    }
}
