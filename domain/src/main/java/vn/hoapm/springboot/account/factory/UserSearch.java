package vn.hoapm.springboot.account.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSearch {
    private String username;
    private String name;

    public UserSearch(String username) {
        this.username = username;
    }
}
