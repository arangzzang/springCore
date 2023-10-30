package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int DiscountFixAmount = 1000;//1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VPI){
            return DiscountFixAmount;
        }
        return 0;
    }
}
