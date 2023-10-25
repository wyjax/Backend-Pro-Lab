package com.wyjax.webfluxstudy;

import com.wyjax.webfluxstudy.study.TestExample;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
class WebfluxStudyApplicationTests {

    TestExample testExample = new TestExample();

    @Test
    void contextLoads() {
    }

    @Test
    public void good() {
        // 확인하면 bad에서는 empty가 reuturn, good에서는 error signal이 방출된다
        Flux<Integer> result = testExample.filterWhen_good();
        System.out.println(result);
    }
}
