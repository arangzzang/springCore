package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        // true로 하면 빈을 찾을수 없다고 에러남 : org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'autoWiredTest.TestBean' : Unsatisfied dependency expressed through method 'setNoBean1' parameter 0: No qualifying bean of type 'hello.core.member.Member' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }

}
