package vn.hoapm.springboot.test.presentation;

import lombok.Data;
import vn.hoapm.springboot.shared.CommonPagingAndSort;
import vn.hoapm.springboot.test.factory.Test;
import java.util.List;

@Data
    public class TestListResponse extends CommonPagingAndSort {
    List<Test> tests;
}
