package vn.hoapm.springboot.test.sql;

import org.springframework.jdbc.object.MappingSqlQuery;
import vn.hoapm.springboot.shared.MappingSQLCommand;
import vn.hoapm.springboot.test.factory.TestDB;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTests extends MappingSqlQuery implements MappingSQLCommand {
    private Map<String, Object> params;


    @Override
    protected Object mapRow(ResultSet rs, int i) throws SQLException {
        TestDB testDB = new TestDB();
        testDB.setId(rs.getLong(TestDB.ID));
        testDB.setName(rs.getString(TestDB.NAME));
        testDB.setUTimestamp(rs.getTimestamp(TestDB.UTIMESTAMP));
        return testDB;
    }

    @Override
    public String prepareSQL() {
        StringBuilder orderBy = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT t.ID,")
                .append(" t.NAME,")
                .append(" t.UTIMESTAMP")
                .append(" FROM TESTS t");
        return builder.toString();
    }

    @Override
    public List<?> executeCommand(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql(prepareSQL());
        this.declareParameters();
        return this.executeByNamedParam(params);
    }

    @Override
    public void prepareParams(Object... parameters) {
        params = new HashMap<>();
    }

    @Override
    public void declareParameters() {
    }
}
