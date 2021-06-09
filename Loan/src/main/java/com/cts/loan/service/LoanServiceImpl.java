package com.cts.loan.service;

import com.cts.loan.model.LoanMaster;
import com.cts.loan.model.UserLoan;
import com.cts.loan.repository.LoanRepository;
import com.cts.loan.repository.UserLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    UserLoanRepository userLoanRepository;

    public UserLoan appliedforLoan(UserLoan loanMasterReqDto) {
        return userLoanRepository.save(loanMasterReqDto);
    }

    public UserLoan updateLoan(UserLoan loanMasterReqDto) {
        return userLoanRepository.save(loanMasterReqDto);
    }

    public List<LoanMaster> getAllLoanDetail() {
        List<LoanMaster> loanMasterList = loanRepository.findAll();
        return loanMasterList;
    }

    public UserLoan deleteLoan(UserLoan loanMasterReqDto) {
        return userLoanRepository.deleteByname(loanMasterReqDto.getName());
    }
}
