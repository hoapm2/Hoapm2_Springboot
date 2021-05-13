package vn.hoapm.springboot.account.service.impl;

import vn.hoapm.springboot.account.factory.User;
import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.account.presentaion.UserResponse;
import vn.hoapm.springboot.account.repository.UserRepository;
import vn.hoapm.springboot.account.service.usecase.UserGetUC;

public class UserGetUCImpl implements UserGetUC {
    private UserResponse userResponse;
    private UserSearch userSearch;
    private final UserRepository repository;

    public UserGetUCImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserGetUC applySearch(UserSearch userSearch) {
        this.userSearch = userSearch;
        return this;
    }

    @Override
    public UserGetUC findByUsername() {
        this.userResponse = repository.findBindUsername(userSearch);
        return this;
    }

    @Override
    public UserResponse endGetByUsername() {
        return this.userResponse;
    }
}
