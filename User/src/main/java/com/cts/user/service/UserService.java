package com.cts.user.service;

import com.cts.user.Model.UserModel;
import com.cts.user.dtos.RegistrationReqDto;

public interface UserService {

    UserModel saveUser(UserModel user);

    UserModel fetchUserByUserName(String userName);

    RegistrationReqDto fetchUserByUserNameAndPassword(RegistrationReqDto loginReq);
}
