package com.cts.user.Model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Setter
@Getter
public class UserModel {

    private String name;

    private String userName;

    private String password;

    private String address;

    private String email;

    private Integer contacts;

    private String dob;
}
