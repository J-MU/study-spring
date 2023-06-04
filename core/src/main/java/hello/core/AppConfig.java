package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.impl.RateDiscountPolicy;
import hello.core.member.Service.MemberService;
import hello.core.member.Service.impl.MemberServiceImpl;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.impl.MemoryMemberRepository;
import hello.core.order.service.OrderService;
import hello.core.order.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
