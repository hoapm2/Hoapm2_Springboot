package vn.hoapm.springboot.test.service.impl;

import vn.hoapm.springboot.shared.AuditLog;
import vn.hoapm.springboot.test.factory.Test;
import vn.hoapm.springboot.test.presentation.TestRequest;
import vn.hoapm.springboot.test.repository.TestRepository;
import vn.hoapm.springboot.test.service.usecase.TestUpdateUC;

import java.sql.Timestamp;

public class TestUpdateUCImpl implements TestUpdateUC {
    private TestRepository testRepository;
    private TestRequest testRequest;
    private Test test;
    private int executedRecord;

    public TestUpdateUCImpl(TestRepository testRepository){
        this.testRepository = testRepository;
        test = new Test();
    }

    @Override
    public TestUpdateUC applyUpdateInfo(TestRequest testRequest) {
        this.testRequest = testRequest;
        return this;
    }

    @Override
    public TestUpdateUC update() {
        test.setId(testRequest.getTestId().getId());
        test.setName(testRequest.getName());
        AuditLog auditLog = new AuditLog().withUTimestamp(Timestamp.from(testRequest.getUTimestamp()));
        test.setAuditLog(auditLog);
        executedRecord = testRepository.update(test);
        return this;
    }

    @Override
    public TestUpdateUC fail() throws Exception {
        if (executedRecord == 0) {
            throw new Exception("Cập nhật kho thất bại");
        }
        return this;
    }

    @Override
    public Test end() {
        return test;
    }
}
