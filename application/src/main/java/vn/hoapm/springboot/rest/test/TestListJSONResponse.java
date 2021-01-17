package vn.hoapm.springboot.rest.test;

import lombok.Data;
import vn.hoapm.springboot.shared.CommonPagingAndSort;

import java.util.List;

@Data
public class TestListJSONResponse extends CommonPagingAndSort {
    List<TestJSONResponse> tests;
}
