package com.cts.user.Repository;

import com.cts.user.Model.UserModel;
import com.cts.user.dtos.RegistrationReqDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, Integer> {

    UserModel findByUserName(String userName);

    RegistrationReqDto findByUserNameAndPassword(String userName, String password);
}
