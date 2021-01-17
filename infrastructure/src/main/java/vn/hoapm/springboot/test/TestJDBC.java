package vn.hoapm.springboot.test;

import vn.hoapm.springboot.test.context.TestInfraContext;
import vn.hoapm.springboot.test.factory.TestDB;
import vn.hoapm.springboot.test.sql.FindTests;
import vn.hoapm.springboot.test.sql.UpdateTest;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class TestJDBC {
    private final DataSource dataSource;
    private TestInfraContext jdbcContext;

    public TestJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<TestDB> findAll() {
        this.jdbcContext = new TestInfraContext(dataSource);
        List<?> result = jdbcContext.withSQLCommand(new FindTests())
                .withParams()
                .executeCommand();
        if (result.size() > 0) {
            return (List<TestDB>) result;
        }
        return new ArrayList<>();
    }
    public int update(TestDB testDB){
        this.jdbcContext = new TestInfraContext(dataSource);
        int executedRecord = jdbcContext.withSQLCommand(new UpdateTest())
                .withParams(testDB)
                .executeUpdate(null);
        return executedRecord;
    }
}
