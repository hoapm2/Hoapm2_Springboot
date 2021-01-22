package vn.hoapm.springboot.account.core;

import lombok.Data;

@Data
public class UserId {
    private Long id;
    private String username;
    private String phone;

    public UserId() {

    }

    public UserId(Long id) {
        this.id = id;
    }
}
