package vn.hoapm.springboot.account.core;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserAuth {
    private String username;
    private String password;

    public UserAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UserAuth(){

    }
}
