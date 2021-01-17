package vn.hoapm.springboot.test.service.impl;

import vn.hoapm.springboot.test.factory.Test;
import vn.hoapm.springboot.test.presentation.TestListResponse;
import vn.hoapm.springboot.test.repository.TestRepository;
import vn.hoapm.springboot.test.service.usecase.TestGetUC;

import java.util.List;

public class TestGetUCImpl implements TestGetUC {
    private final TestRepository testRepository;
    private List<Test> tests;

    public TestGetUCImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public TestGetUC getAll() {
       this.tests = testRepository.findAll();
       return this;
    }

    @Override
    public TestListResponse endGetAll() {
        TestListResponse listResponse = new TestListResponse();
        listResponse.setTests(tests);
        return listResponse;
    }
}
