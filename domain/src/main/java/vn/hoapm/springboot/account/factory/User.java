package vn.hoapm.springboot.account.factory;

import lombok.Data;
import vn.hoapm.springboot.account.core.UserId;
import vn.hoapm.springboot.shared.AuditLog;

import java.sql.Date;

@Data
public class User {
    private UserId userId;
    private String name;
    private String username;
    private String password;
    private String phone;
    private Integer gender;
    private Date dob;
    private String avatar;
    private Integer role;
    private AuditLog auditLog;
}
