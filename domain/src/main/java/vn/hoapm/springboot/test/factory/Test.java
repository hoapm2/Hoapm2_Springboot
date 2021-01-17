package vn.hoapm.springboot.test.factory;

import lombok.Data;
import vn.hoapm.springboot.shared.AuditLog;

@Data
public class Test {
    private Long id;
    private String name;
    private AuditLog auditLog;
}
