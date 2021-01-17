package vn.hoapm.springboot.test.mapper;

import org.apache.poi.ss.formula.functions.T;
import vn.hoapm.springboot.shared.AuditLog;
import vn.hoapm.springboot.test.factory.Test;
import vn.hoapm.springboot.test.factory.TestDB;

public class TestDBMapper {
    private static TestDBMapper INSTANCE;

    private TestDBMapper() {
    }

    public static TestDBMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestDBMapper();
        }
        return INSTANCE;
    }

    public Test fromDB(TestDB testDB) {
        if (testDB == null) {
            return null;
        }
        Test test = new Test();
        test.setId(testDB.getId());
        test.setName(testDB.getName());
        AuditLog auditLog = new AuditLog().withUTimestamp(testDB.getUTimestamp());
        test.setAuditLog(auditLog);
        return test;
    }

    public TestDB fromObj(Test test) {
        TestDB testDB = new TestDB();
        if (test!=null){
            testDB.setId(test.getId());
            testDB.setName(test.getName());
            testDB.setUTimestamp(test.getAuditLog().getUTimestamp());
        }
        return testDB;
    }


}
