package vn.hoapm.springboot.rest.test;

import lombok.Data;

import java.time.Instant;

@Data
public class TestJSONResponse {
    private Long id;
    private String name;
    private Instant uTimestamp;
}
