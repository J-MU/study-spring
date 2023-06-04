package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.impl.JpaMemberRepository;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
////        return new JpaMemberRepository();
//    }
}
