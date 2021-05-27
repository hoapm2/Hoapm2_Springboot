package vn.hoapm.springboot.account.repository;

import vn.hoapm.springboot.account.factory.User;
import vn.hoapm.springboot.account.factory.UserCUD;
import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.account.presentaion.UserResponse;


public interface UserRepository {
    UserResponse findBindUsername(UserSearch search);

    long create(UserCUD userCUD);

    int createRole(User user);
}
