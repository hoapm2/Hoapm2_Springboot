package vn.hoapm.springboot.test.context;

import vn.hoapm.springboot.shared.InfraContext;
import vn.hoapm.springboot.test.core.TestId;

import javax.sql.DataSource;

public class TestInfraContext extends InfraContext<TestId> {

    public TestInfraContext(DataSource ds) {
        super(ds);
    }
}
