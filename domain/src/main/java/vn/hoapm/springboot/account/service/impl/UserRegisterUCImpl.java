package vn.hoapm.springboot.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.hoapm.springboot.account.factory.User;
import vn.hoapm.springboot.account.factory.UserCUD;
import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.account.presentaion.UserResponse;
import vn.hoapm.springboot.account.repository.UserRepository;
import vn.hoapm.springboot.account.service.usecase.UserRegisterUC;

public class UserRegisterUCImpl implements UserRegisterUC {
    private final UserRepository repository;
    private UserCUD userCUD;
    private long idReturn;
    private UserResponse userResponse;


    @Autowired
    PasswordEncoder passwordEncoder;


    public UserRegisterUCImpl(UserRepository repository) {
        this.repository = repository;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserRegisterUC applyRequest(UserCUD userCUD) {
        this.userCUD = userCUD;
        return this;
    }

    @Override
    public UserRegisterUC validate() {
        return this;
    }

    @Override
    public UserRegisterUC encodePassword() {
        userCUD.setPassword(passwordEncoder.encode(userCUD.getPassword()));
        return this;
    }


    @Override
    public UserRegisterUC createPersonalAccount() {
        idReturn = repository.create(userCUD);
        return this;
    }

    @Override
    public UserRegisterUC createRoles() {
        if (idReturn > 0){
            User user = User.builder()
                .roleCode(userCUD.getRoleCode())
                .id(idReturn)
                .build();
            int executedRecord = repository.createRole(user);

        }
        return this;
    }

    @Override
    public UserRegisterUC checkInsertSuccess() {
        if (idReturn == 0)
        {

        } else {
            UserSearch search = UserSearch.builder()
                    .username(userCUD.getUsername())
                    .build();
            userResponse = repository.findBindUsername(search);
        }
        return this;
    }


    @Override
    public UserResponse end() {
        return userResponse;
    }
}
