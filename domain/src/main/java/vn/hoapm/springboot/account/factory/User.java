package vn.hoapm.springboot.account.factory;

import lombok.Builder;
import lombok.Data;
import vn.hoapm.springboot.shared.AuditLog;

import java.sql.Date;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String phone;
    private int gender;
    private Date dob;
    private String avatar;
    private String roleCode;
    private String roleName;
    private AuditLog auditLog;
}
