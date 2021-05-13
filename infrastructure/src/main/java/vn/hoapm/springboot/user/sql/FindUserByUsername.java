package vn.hoapm.springboot.user.sql;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.object.MappingSqlQuery;
import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.account.presentaion.UserResponse;
import vn.hoapm.springboot.shared.BaseQuery;
import vn.hoapm.springboot.user.factory.UserDB;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class FindUserByUsername extends MappingSqlQuery<UserResponse> implements BaseQuery {
    public FindUserByUsername(DataSource dataSource) {
        super();
        this.setDataSource(dataSource);
        this.setSql(buildSQL());
        this.declareParameters();
        this.compile();
    }

    @Override
    protected UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserResponse userResponse = UserResponse
                .builder()
                .id(rs.getLong(UserDB.ID))
                .name(rs.getString(UserDB.NAME))
                .username(rs.getString(UserDB.USERNAME))
                .password(rs.getString(UserDB.PASSWORD))
                .phone(rs.getString(UserDB.PHONE))
                .build();
        return userResponse;
    }


    @Override
    public String buildSQL() {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT ID,")
                .append(" NAME,")
                .append(" USERNAME,")
                .append(" PASSWORD,")
                .append(" PHONE,")
                .append(" UTIMESTAMP ")
                .append(" FROM users u")
                .append(" WHERE ")
                .append(" u.USERNAME = :" + UserDB.USERNAME );
        return builder.toString();
    }

    @Override
    public void declareParameters() {
        declareParameter(new SqlParameter(UserDB.USERNAME, Types.VARCHAR));
    }

    public List<UserResponse> execute(UserSearch search) throws DataAccessException {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(UserDB.USERNAME, search.getUsername());
        return super.executeByNamedParam(map.getValues());
    }
}
