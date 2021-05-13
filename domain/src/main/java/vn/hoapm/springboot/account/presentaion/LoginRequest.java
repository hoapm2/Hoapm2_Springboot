package vn.hoapm.springboot.account.presentaion;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
