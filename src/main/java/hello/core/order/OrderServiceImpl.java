package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService { //주문 서비스 구현체
    private final MemberRepository memberRepository;
   // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
   // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //역할과 구현을 분리했다 ㅇ
    //다향성, 인터페이스와 구현 객체 분리 ㅇ
    //ocp, dip같은 원칙 준수 x ->
    //인터페이스에 의존해라 !!! 구현클래스 의존 x

    private DiscountPolicy discountPolicy;
    //인터페이스에만 의존. 구체적인 클래스 전혀 모름.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //인터페이스에만 의존.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
