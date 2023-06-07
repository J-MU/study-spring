package hello.core.beanfind;

import hello.core.AutoAppConfig;
import hello.core.member.Service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan1() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        System.out.println("================");
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinitionName.contains("memberService")) {
                if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                    System.out.println("beanDefinitionName : " + beanDefinitionName +
                            " beanDefinition : " + beanDefinition);
                }
            }

        }
        System.out.println("================");
    }

    @Test
    void basicScan() {
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println(memberService);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
