package hello.core.order.service.impl;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.impl.FixDiscountPolicy;
import hello.core.discount.impl.RateDiscountPolicy;
import hello.core.member.model.Member;
import hello.core.member.repository.MemberRepository;
import hello.core.order.Order;
import hello.core.order.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
