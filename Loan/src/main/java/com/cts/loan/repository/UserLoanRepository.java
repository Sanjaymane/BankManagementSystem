package com.cts.loan.repository;

import com.cts.loan.model.UserLoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoanRepository extends MongoRepository<UserLoan, Integer> {

    UserLoan deleteByname(String name);
}
