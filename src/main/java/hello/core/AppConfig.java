package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {// 앱 전체를 설정하고 구성하는 class
    public MemberService memberService(){ // 생성자 주입해서 DIP준수
        return new MemberServiceImpl(memberRepository());
    }
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }





}
