package vn.hoapm.springboot.test.service;

import vn.hoapm.springboot.test.factory.Test;
import vn.hoapm.springboot.test.presentation.TestListResponse;
import vn.hoapm.springboot.test.presentation.TestRequest;
import vn.hoapm.springboot.test.repository.TestRepository;
import vn.hoapm.springboot.test.service.impl.TestGetUCImpl;
import vn.hoapm.springboot.test.service.impl.TestUpdateUCImpl;
import vn.hoapm.springboot.test.service.usecase.TestGetUC;
import vn.hoapm.springboot.test.service.usecase.TestUpdateUC;

public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestListResponse getAll() {
        TestGetUC usecase = new TestGetUCImpl(testRepository);
        TestListResponse listResponse = usecase
                .getAll()
                .endGetAll();
        return listResponse;
    }
    public Test update(TestRequest request) throws Exception {
        TestUpdateUC usecase = new TestUpdateUCImpl(testRepository);
        Test test = usecase.applyUpdateInfo(request)
                .update()
                .fail()
                .end();
        return null;
    }
}
