package vn.hoapm.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import vn.hoapm.springboot.shared.InfraConfig;
import vn.hoapm.springboot.test.repository.TestRepository;
import vn.hoapm.springboot.test.service.TestService;

@Configuration
@Import({InfraConfig.class})
public class RESTAppConfig {

    @Bean
    TestService standardTestService(TestRepository testRepository) {
        return new TestService(testRepository);
    }

}
