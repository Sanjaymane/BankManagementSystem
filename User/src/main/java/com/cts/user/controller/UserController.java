package com.cts.user.controller;

import com.cts.user.Model.UserModel;
import com.cts.user.configuration.ResponseVO;
import com.cts.user.dtos.RegistrationReqDto;
import com.cts.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin()
public class UserController {

    @Autowired
    UserService userServiceImpl;

    @PostMapping("/registration")
    public ResponseEntity registerUser(@RequestBody UserModel registerUser) {

        ResponseVO responseVO = new ResponseVO();

        UserModel existing = userServiceImpl.fetchUserByUserName(registerUser.getUserName());

        if (existing != null) {
            responseVO.setMessage("There is already an account registered with that email");
            responseVO.setStatusCode("201");
            responseVO.setResult(registerUser);
            return new ResponseEntity(responseVO, HttpStatus.CREATED);

        } else {

            registerUser = userServiceImpl.saveUser(registerUser);
            responseVO.setMessage("User Created");
            responseVO.setStatusCode("200");
            responseVO.setResult(registerUser);
            return new ResponseEntity(responseVO, HttpStatus.CREATED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody RegistrationReqDto loginReq){

        loginReq = userServiceImpl.fetchUserByUserNameAndPassword(loginReq);

        if (loginReq.getUserName() != null & loginReq.getPassword() !=null ) {

            ResponseVO responseVO = new ResponseVO();
            responseVO.setMessage("login Success");
            responseVO.setStatusCode("200");
            responseVO.setResult(loginReq);
            return new ResponseEntity(responseVO, HttpStatus.CREATED);
        }else{
            ResponseVO responseVO = new ResponseVO();
            responseVO.setMessage("login Failed");
            responseVO.setStatusCode("403");
            responseVO.setResult(loginReq);
            return new ResponseEntity(responseVO, HttpStatus.UNAUTHORIZED);
        }

    }


}
