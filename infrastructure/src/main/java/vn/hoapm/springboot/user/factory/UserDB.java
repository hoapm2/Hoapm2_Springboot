package vn.hoapm.springboot.user.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data

public class UserDB {

    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String PHONE = "PHONE";
    public static final String EMAIL = "EMAIL";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String UTIMESTAMP = "UTIMESTAMP";
    public static final String CREATED_AT = "CREATED_AT";
    public static final String USER_ID = "USER_ID";
    public static final String ROLE_NAME = "ROLE_NAME";
    public static final String ROLE_ID = "ROLE_ID";
}
