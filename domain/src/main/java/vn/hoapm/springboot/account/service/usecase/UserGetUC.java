package vn.hoapm.springboot.account.service.usecase;

import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.account.presentaion.UserResponse;

public interface UserGetUC {
    UserGetUC applySearch(UserSearch userSearch);

    UserGetUC findByUsername();

    UserResponse endGetByUsername();
}
