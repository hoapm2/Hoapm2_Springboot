package vn.hoapm.springboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.hoapm.springboot.account.factory.User;
import vn.hoapm.springboot.account.factory.UserCUD;
import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.account.presentaion.UserResponse;
import vn.hoapm.springboot.account.repository.UserRepository;
import vn.hoapm.springboot.user.sql.CreateAccount;
import vn.hoapm.springboot.user.sql.CreateRole;
import vn.hoapm.springboot.user.sql.FindUserByUsername;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final DataSource dataSource;
    private FindUserByUsername findUserByUsername;
    private CreateAccount createAccount;
    private CreateRole createRole;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void compileSQL() {
        findUserByUsername = new FindUserByUsername(dataSource);
        createAccount = new CreateAccount(dataSource);
        createRole = new CreateRole(dataSource);
    }

    @Override
    public UserResponse findBindUsername(UserSearch search) {
        List<UserResponse> result = findUserByUsername.execute(search);
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public long create(UserCUD userCUD) {
        return createAccount.execute(userCUD);
    }

    @Override
    public int createRole(User user) {
        return createRole.execute(user);
    }
}
