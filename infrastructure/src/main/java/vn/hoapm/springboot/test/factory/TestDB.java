package vn.hoapm.springboot.test.factory;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TestDB {
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String UTIMESTAMP = "UTIMESTAMP";
    private Long id;
    private String name;
    private Timestamp uTimestamp;
}
