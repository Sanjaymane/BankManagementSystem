package com.cts.loan.service;

import com.cts.loan.model.LoanMaster;
import com.cts.loan.model.UserLoan;

import java.util.List;

public interface LoanService {

    UserLoan appliedforLoan(UserLoan loanMasterReqDto);

    UserLoan updateLoan(UserLoan loanMasterReqDto);

    List<LoanMaster> getAllLoanDetail();

    UserLoan deleteLoan(UserLoan loanMasterReqDto);
}
