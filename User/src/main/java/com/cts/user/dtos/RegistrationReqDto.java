package com.cts.user.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegistrationReqDto {

    private String name;
    private String userName;
    private String password;
    private Integer token;

   /* private String guardianName;
    private String address;
    private String email;
    private String maritalStatus;
    private long contactno;
    private String dob;
    private String acctType;*/
}
