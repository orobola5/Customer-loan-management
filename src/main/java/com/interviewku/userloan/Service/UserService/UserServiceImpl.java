package com.interviewku.userloan.Service.UserService;

import com.interviewku.userloan.Dto.Request.UserRequest;
import com.interviewku.userloan.Dto.Response.User.UserResponse;

import com.interviewku.userloan.Model.Loan;
import com.interviewku.userloan.Model.User;
import com.interviewku.userloan.Repository.AddressRepository;
import com.interviewku.userloan.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    @Override
    public UserResponse createUser(UserRequest request) {
        UserResponse apiResponse= new UserResponse();
        List<User> existingUser=userRepository.findAllByEmail(request.getEmail());
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
        user.setPassword(request.getPassword());
        user.setAccountNumber(request.getAccountNumber());
        user.setAddress(request.getAddress());
        User registeredUser=userRepository.save(user);
        apiResponse.setUser(registeredUser);
        apiResponse.setMessage("user is created");

        return apiResponse;
    }

    @Override
    public List<UserResponse> searchUserByEmail(String email) {
        return null;
    }

    @Override
    public UserResponse getAllUser() {
        return null;
    }

    @Override
    public List<UserResponse> searchUserByLoan(Loan loan) {
        return null;
    }
}
