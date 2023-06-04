package hello.core.discount.impl;

import hello.core.discount.DiscountPolicy;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount =1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
