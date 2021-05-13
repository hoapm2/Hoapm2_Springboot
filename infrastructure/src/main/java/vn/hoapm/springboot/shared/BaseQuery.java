package vn.hoapm.springboot.shared;

public interface BaseQuery {

    String buildSQL();

    void declareParameters();
}
