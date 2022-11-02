package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp { //주문과 할인 정책 실행

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        //기존엔 직접 new로 생성했지만 appconfig 에서 객체 생성과 인터페이스에 어떤 객체가 할당될 지 정함
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }

}
