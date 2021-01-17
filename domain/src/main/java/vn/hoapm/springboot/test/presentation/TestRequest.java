package vn.hoapm.springboot.test.presentation;

import lombok.Data;
import vn.hoapm.springboot.test.core.TestId;

import java.time.Instant;

@Data
public class TestRequest {
    private TestId testId;
    private String name;
    private Instant uTimestamp;
}
