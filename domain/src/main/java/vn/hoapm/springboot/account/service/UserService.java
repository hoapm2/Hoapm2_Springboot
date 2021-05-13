package vn.hoapm.springboot.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vn.hoapm.springboot.account.presentaion.UserResponse;
import vn.hoapm.springboot.account.presentaion.UserRequest;
import vn.hoapm.springboot.account.repository.UserRepository;
import vn.hoapm.springboot.account.service.impl.UserGetUCImpl;
import vn.hoapm.springboot.account.service.impl.UserRegisterUCImpl;
import vn.hoapm.springboot.account.service.usecase.UserGetUC;
import vn.hoapm.springboot.account.service.usecase.UserRegisterUC;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserResponse findByUsername(UserRequest userRequest) {
        UserGetUC userGetUC = new UserGetUCImpl(userRepository);
        UserResponse userResponse = userGetUC.applySearch(userRequest.getUserSearch())
                .findByUsername()
                .endGetByUsername();
        return userResponse;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserResponse register (UserRequest userRequest){
        UserRegisterUC userRegisterUC = new UserRegisterUCImpl(userRepository);
        UserResponse userResponse = userRegisterUC
                .applyRequest(userRequest.getCud())
                .validate()
                .encodePassword()
                .create()
                .check()
                .end();
        return userResponse;
    }
}
