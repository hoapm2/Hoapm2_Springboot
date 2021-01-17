package vn.hoapm.springboot.test.service.usecase;

import vn.hoapm.springboot.test.presentation.TestListResponse;

public interface TestGetUC {
    TestGetUC getAll();

    TestListResponse endGetAll();
}
