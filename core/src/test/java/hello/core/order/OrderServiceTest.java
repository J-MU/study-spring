package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Service.MemberService;
import hello.core.member.Service.impl.MemberServiceImpl;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;
import hello.core.order.service.OrderService;
import hello.core.order.service.impl.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService=appConfig.memberService();
        orderService= appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
