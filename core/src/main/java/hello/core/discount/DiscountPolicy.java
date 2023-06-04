package hello.core.discount;

import hello.core.member.model.Member;

public interface DiscountPolicy {
    /*
     * @return 할인 대상 금액
     *
     */
    int discount(Member member, int price);

}
