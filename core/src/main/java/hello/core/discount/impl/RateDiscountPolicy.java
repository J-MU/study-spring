package hello.core.discount.impl;

import hello.core.discount.DiscountPolicy;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPolicy=10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price*discountPolicy/100;
        }

        return 0;
    }
}
