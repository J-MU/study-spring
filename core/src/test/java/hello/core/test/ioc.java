package hello.core.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ioc {
    @Test
    public void test() {
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(TestConfig.class);

        Database mySQL = ac.getBean(Database.class);
        mySQL.sendQuery();

    }


    @Configuration
    static class TestConfig{

        @Bean
        public Database getDatabase() {
            return new Oracle();
        }
    }
}
