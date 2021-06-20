package com.cts.loan.controller;

import com.cts.loan.configuration.ResponseVO;
import com.cts.loan.model.LoanMaster;
import com.cts.loan.model.UserLoan;
import com.cts.loan.service.LoanService;
import exception.BankManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping("/getAllLoan")
    public ResponseEntity getAllLoanDetail() throws BankManagementException{

        ResponseVO responseVO = new ResponseVO();

        List<LoanMaster> list = loanService.getAllLoanDetail();

        if (list != null) {

            responseVO.setStatusCode("200");
            responseVO.setResult(list);
            responseVO.setMessage("Data Found");
            return new ResponseEntity(responseVO, HttpStatus.OK);

        } else {

            throw new BankManagementException("Data Not Found");
        }
    }

    @PostMapping("/applyLoan")
    public ResponseEntity applyLoan(@RequestBody UserLoan loanMasterReqDto) throws BankManagementException {

        ResponseVO responseVO = new ResponseVO();

        UserLoan appliedforLoanMaster = loanService.appliedforLoan(loanMasterReqDto);

        if (appliedforLoanMaster != null) {

            responseVO.setStatusCode("201");
            responseVO.setResult(loanMasterReqDto);
            responseVO.setMessage("Insert success");
            return new ResponseEntity(responseVO, HttpStatus.OK);

        } else {
            throw new BankManagementException("Not Inserted");
        }
    }

    @PutMapping("/updateLoan")
    public ResponseEntity updateLoan(@RequestBody UserLoan loanMasterReqDto) throws BankManagementException {

        ResponseVO responseVO = new ResponseVO();

        UserLoan updateLoan = loanService.updateLoan(loanMasterReqDto);

        if (updateLoan != null) {

            responseVO.setStatusCode("201");
            responseVO.setResult(loanMasterReqDto);
            responseVO.setMessage("Updated success");
            return new ResponseEntity(responseVO, HttpStatus.OK);

        } else {
            throw new BankManagementException("Not Inserted");
        }
    }

    @DeleteMapping()
    public ResponseEntity deleteLoan(@RequestBody UserLoan loanMasterReqDto)throws BankManagementException {

        ResponseVO responseVO = new ResponseVO();

        UserLoan updateLoan = loanService.deleteLoan(loanMasterReqDto);

        if (updateLoan != null) {

            responseVO.setStatusCode("201");
            responseVO.setResult(loanMasterReqDto);
            responseVO.setMessage("deleted success");
            return new ResponseEntity(responseVO, HttpStatus.OK);

        } else {
            throw new BankManagementException("Failed to remove");
        }
    }

}
