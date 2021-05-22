package vn.hoapm.springboot.account.core;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class UserAuth {
    private String username;
    private String password;
    private String role;

    public UserAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
