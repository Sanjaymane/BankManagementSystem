package com.cts.loan.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class LoanReqDto {

    private Integer loanId;

    private String loantype;

    private Date applyDate;

    private Integer loanAmount;
}
