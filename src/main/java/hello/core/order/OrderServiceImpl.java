package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final이 붙어있는 필수 생성자를 lombok이 똑같이 만들어준다.
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new  FixDiscountPolicy();//DIP위반

    /**
     * 일반 메서드 주입 특징 :
     * 한번에 여러 필드를 주입 받을 수 있다.
     * 일반적으로 잘 사용하지 않는다.
     * */
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;
//
//    @Autowired
//    public void init (MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    /**
     * 필드 주입 특징 :
     * 한번에 여러 필드를 주입 받을 수 있다.
     * 일반적으로 잘 사용하지 않는다.
     * ps. 하지만 권장하지않는다. 외부에서 변경이 불가능해서 테스트 하기 힘들다는 치명적인
     * 단점있기 때문이다.
     * 하여 아무도 사용하지않는 테스트 코드 혹은 특수한 경우에만 임의로 사용한다.
     * */
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

    /**
     * 생성자 주입 특징 :
     * 생성자 호출시점에 딱 1번만 호출되는 것이 보장된다.
     * 불변, 필수 의존관계에 사용
     * */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 생성자 주입 특징 :
     * 선택, 변경 가능성이 있는 의존관계에 사용
     * 자바빈 프로퍼티 규약의 수정자 메서드 방식을 사용하는 방법이다.
     * */
    /*private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired
    public setMemberRepository(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String ItemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, ItemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
