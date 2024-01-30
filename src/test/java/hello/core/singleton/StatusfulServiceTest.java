package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatusfulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefullService1 = ac.getBean(StatefulService.class);
        StatefulService statefullService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자 10000원 주문
        int userAPrice = statefullService1.order("userA", 10000);
        // ThreadB : B사용자 20000원 주문
        int userBPrice = statefullService2.order("userB", 20000);

        // ThreadA : A사용자 주문 금액 조회
//        int price = statefullService1.getPrice();
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(statefullService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}