package vn.hoapm.springboot.shared;

import javax.sql.DataSource;
import java.util.List;

public class InfraContext<A> {
    private final DataSource dataSource;
    private MappingSQLCommand queryCommand;
    private UpdateSQLCommand<A> updateCommand;

    public InfraContext(DataSource ds) {
        this.dataSource = ds;
    }

    public List<?> executeCommand() {
        return this.queryCommand.executeCommand(dataSource);
    }

    public int executeUpdate(A a) {
        return this.updateCommand.updateCommand(dataSource, a);
    }

    public InfraContext<A> withSQLCommand(MappingSQLCommand command) {
        this.queryCommand = command;
        this.updateCommand = null;
        return this;
    }

    public InfraContext<A> withSQLCommand(UpdateSQLCommand command) {
        this.updateCommand = command;
        this.queryCommand = null;
        return this;
    }

    public InfraContext<A> withParams(Object... parameters) {
        if (updateCommand != null) {
            this.updateCommand.prepareParams(parameters);
        }
        if (queryCommand != null) {
            this.queryCommand.prepareParams(parameters);
        }
        return this;
    }
}
