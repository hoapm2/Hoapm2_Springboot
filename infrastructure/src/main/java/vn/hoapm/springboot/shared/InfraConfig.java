package vn.hoapm.springboot.shared;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import vn.hoapm.springboot.test.TestJDBC;
import vn.hoapm.springboot.test.TestRepositoryImpl;
import vn.hoapm.springboot.test.repository.TestRepository;

import javax.sql.DataSource;

@Configuration
public class InfraConfig {

    @Bean
    public DataSource mySqlDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

//        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/springboot_database");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("hoa123456");

        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceBuilder.url("jdbc:sqlserver://DESKTOP-M8ASORT;databaseName=hoapmSpring");
        dataSourceBuilder.username("hoapm");
        dataSourceBuilder.password("hoa123456");

        return dataSourceBuilder.build();
    }
    @Bean
    TestJDBC standardTestJDBC(DataSource dataSource) {
        return new TestJDBC(dataSource);
    }

    @Bean
    TestRepository standardTestRepository(TestJDBC testJDBC) {
        TestRepository repository = new TestRepositoryImpl(testJDBC);
        return repository;
    }


}
