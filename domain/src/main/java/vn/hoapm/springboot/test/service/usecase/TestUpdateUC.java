package vn.hoapm.springboot.test.service.usecase;

import vn.hoapm.springboot.test.factory.Test;
import vn.hoapm.springboot.test.presentation.TestRequest;

public interface TestUpdateUC {
    TestUpdateUC applyUpdateInfo(TestRequest request);

    TestUpdateUC update();

    TestUpdateUC fail() throws Exception;

    Test end();
}
