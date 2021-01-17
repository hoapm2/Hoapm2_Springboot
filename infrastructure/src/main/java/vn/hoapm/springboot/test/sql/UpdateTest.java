package vn.hoapm.springboot.test.sql;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import vn.hoapm.springboot.shared.UpdateSQLCommand;
import vn.hoapm.springboot.test.core.TestId;
import vn.hoapm.springboot.test.factory.TestDB;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class UpdateTest extends SqlUpdate implements UpdateSQLCommand<TestId> {

    private Map<String, Object> params;

    public UpdateTest() {
    }


    @Override
    public String prepareSQL() {
        StringBuilder builder = new StringBuilder();
        builder.append(" UPDATE TESTS SET ");
        builder.append("  NAME = :NAME, ");
        builder.append("  UTIMESTAMP = CURRENT_TIME() ");
        builder.append(" WHERE ID = :" + TestDB.ID + " AND UTIMESTAMP = :" + TestDB.UTIMESTAMP);
        return builder.toString();
    }

    @Override
    public int updateCommand(DataSource dataSource, TestId testId) {
        this.setDataSource(dataSource);
        this.setSql(this.prepareSQL());
        this.declareParameters();
        compile();
        int executedRecord = this.updateByNamedParam(params);
        return executedRecord;
    }

    @Override
    public void prepareParams(Object... parameters) {
        TestDB objDB = (TestDB) parameters[0];
        params = new HashMap<>();
        params.put(TestDB.ID, objDB.getId());
        params.put(TestDB.NAME, objDB.getName());
        params.put(TestDB.UTIMESTAMP, objDB.getUTimestamp());
    }

    @Override
    public void declareParameters() {
        declareParameter(new SqlParameter(TestDB.ID, Types.NUMERIC));
        declareParameter(new SqlParameter(TestDB.NAME, Types.VARCHAR));
        declareParameter(new SqlParameter(TestDB.UTIMESTAMP, Types.TIMESTAMP));
    }
}
