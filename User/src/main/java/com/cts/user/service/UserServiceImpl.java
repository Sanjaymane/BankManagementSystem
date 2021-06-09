package com.cts.user.service;

import com.cts.user.Model.UserModel;
import com.cts.user.Repository.UserRepository;
import com.cts.user.dtos.RegistrationReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    public UserModel saveUser(UserModel user) {
        return userRepo.save(user);
    }
    public UserModel fetchUserByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }
    public RegistrationReqDto fetchUserByUserNameAndPassword(RegistrationReqDto loginReq) {

        loginReq = userRepo.findByUserNameAndPassword(loginReq.getUserName(), loginReq.getPassword());

        Random r = new Random();
        int low = 1000;
        int high = 100000;
        int result = r.nextInt(high-low) + low;
        loginReq.setToken(result);

        return loginReq;
    }

}
