package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // 예제코드로 등록된 configuration을 살리기위해 사용됨.
        // @ComponentScan으로 등록되지 않은 디폴트 상태이면 해당 클래스의 하위 패키지들 전부 등록함.
//        basePackages = "hello.core.member", // member만 컴포넌트 스캔으로 등록함.
//        basePackageClasses = AutoAppConfig.class, // 지정한 클래스의 패키지를 탐색 시작 위치로 지정한다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

/**
 * @interface라고 쓰여있으면 annotation 으로 알고있으면 된다.
 * @Controller : 스프링 MVC 컨트롤러로 인식
 * @Repository : 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다.
 * @Configuration : 앞서 보았듯이 스프링 설정 정보로 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리
 * 를 한다.
 * @Service : 사실 @Service 는 특별한 처리를 하지 않는다. 대신 개발자들이 핵심 비즈니스 로직이 여기에 있
 * 겠구나 라고 비즈니스 계층을 인식하는데 도움이 된다.
 * */
public class AutoAppConfig {
    /*
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    */
}





