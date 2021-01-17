package vn.hoapm.springboot.test;

import vn.hoapm.springboot.test.factory.Test;
import vn.hoapm.springboot.test.factory.TestDB;
import vn.hoapm.springboot.test.mapper.TestDBMapper;
import vn.hoapm.springboot.test.repository.TestRepository;

import java.util.ArrayList;
import java.util.List;

public class TestRepositoryImpl implements TestRepository {
    private TestJDBC testJDBC;

    public TestRepositoryImpl(TestJDBC testJDBC) {
        this.testJDBC = testJDBC;
    }

    @Override
    public List<Test> findAll() {
        List<Test> tests = new ArrayList<>();
        List<TestDB> testDBS = testJDBC.findAll();
        if (testDBS.size() > 0) {
            for (TestDB testDB : testDBS
            ) {
                tests.add(TestDBMapper.getInstance().fromDB(testDB));
            }
        }
        return tests;
    }

    @Override
    public int update(Test test) {
        TestDB testDB = TestDBMapper.getInstance().fromObj(test);
        return testJDBC.update(testDB);
    }
}
