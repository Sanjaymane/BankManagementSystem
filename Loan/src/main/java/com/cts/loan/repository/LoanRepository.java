package com.cts.loan.repository;

import com.cts.loan.model.LoanMaster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends MongoRepository<LoanMaster, Integer> {

}

