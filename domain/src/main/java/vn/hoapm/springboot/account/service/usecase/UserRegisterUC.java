package vn.hoapm.springboot.account.service.usecase;

import vn.hoapm.springboot.account.factory.UserCUD;
import vn.hoapm.springboot.account.presentaion.UserResponse;

public interface UserRegisterUC {
    UserRegisterUC applyRequest(UserCUD userCUD);

    UserRegisterUC validate();

    UserRegisterUC encodePassword();

    UserRegisterUC createPersonalAccount();

    UserRegisterUC checkInsertSuccess();

    UserRegisterUC createRoles();

    UserResponse end();
}
