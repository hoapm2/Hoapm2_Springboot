package vn.hoapm.springboot.account.repository;

import org.springframework.stereotype.Repository;
import vn.hoapm.springboot.account.factory.User;
import vn.hoapm.springboot.account.factory.UserCUD;
import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.account.presentaion.UserResponse;


public interface UserRepository {
    UserResponse findBindUsername(UserSearch search);

    int create(UserCUD userCUD);
}
