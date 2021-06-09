package com.cts.loan.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "loan_master")
@Setter
@Getter
public class LoanMaster {

    private Integer loanId;

    private String loantype;

    private Date applyDate;

    private Integer loanAmount;

}
