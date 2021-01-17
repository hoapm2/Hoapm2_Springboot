package vn.hoapm.springboot.test.repository;

import vn.hoapm.springboot.test.factory.Test;

import java.util.List;

public interface TestRepository {
    List<Test> findAll();

    int update(Test test);
}
