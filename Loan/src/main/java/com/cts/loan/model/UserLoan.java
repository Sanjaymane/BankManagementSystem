package com.cts.loan.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_loan")
@Setter
@Getter
public class UserLoan {

    private String name;

    private String loantype;

    private Integer loanId;

    private Integer loanAmount;

    private String customerId;


}
