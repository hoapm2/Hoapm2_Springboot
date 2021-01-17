package vn.hoapm.springboot.test.core;

import lombok.Data;

@Data
public class TestId {
    private Long id;
    public TestId(Long id) {
        this.id = id;
    }

    public TestId() {
    }
}
