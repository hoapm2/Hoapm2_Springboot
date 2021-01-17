package vn.hoapm.springboot.shared;

import lombok.Data;

@Data
public class CommonPagingAndSort {

    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalCount;

    public CommonPagingAndSort() {
    }

    public CommonPagingAndSort(Integer pageIndex, Integer pageSize, Integer totalCount) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }
}
