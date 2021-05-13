package vn.hoapm.springboot.account.presentaion;

import lombok.Data;
import vn.hoapm.springboot.account.factory.UserCUD;
import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.shared.PagingSortFilter;

@Data
public class UserRequest {
    private UserSearch userSearch;
    private UserCUD cud;
    private PagingSortFilter pagingSortFilter;
}
