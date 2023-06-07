package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void PrototypeTest() {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(prototypeBean.class);

        System.out.println("find prototypeBean1");
        prototypeBean bean1 = ac.getBean(prototypeBean.class);

        System.out.println("find prototypeBean2");
        prototypeBean bean2 = ac.getBean(prototypeBean.class);

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        Assertions.assertThat(bean1).isNotSameAs(bean2);

        ac.close();
    }

    @Scope("prototype")
    static class prototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("prototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("prototypeBean.destroy");
        }
    }

}
