package com.wyjax.webfluxstudy.study;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class TestExample {

    public Flux<Integer> mapUsable_before() {
        return Flux.just(-1, 0, 1)
            .flatMap(id -> {
                // integer + 1 같은 경우는 map으로 변환해도 된다. 아래 after 예제에서 확인
                int new_integer = id + 1;
                return reactiveOp(new_integer);
            });
    }

    // 아래와 같이 변경해도 성능의 차이는 크지 않지만, 코드 이해 시간은 차이가 난다
    public Flux<Integer> mapUsable_after() {
        return Flux.just(-1, 0, 1)
            .map(integer -> integer + 1)
            .flatMap(this::reactiveOp);
    }

    // doOnNext는 보통 로그를 남길 때 많이 사용한다고 한다
    public Flux<Integer> doOnNext() {
        return Flux.just(1, 2, 3, 4)
            .doOnNext(integer -> log.info("next integer={}", integer))
//            .flatMap(integer -> {
//                log.info("next integer={}", integer);
//                return reactiveOp(integer);
//            })
            // 위의 코드를 아래처럼 표현할 수 있다.
            .flatMap(this::reactiveOp);
        /**
         오퍼레이터 분리는 언제까지나 가독성을 분리하기 위한 작업이다.
         그렇기에 억지로 변경할 필요까지는 없음
         */
    }

    // java 8 stream filter와 비슷하게 동작함, true면 방출 false면 방출 안함
    public Flux<Integer> filter_example() {
        return Flux.just(1, 0, 3)
            .filter(this::isZero);
    }

    public boolean isZero(int num) {
        return 0 == num;
    }

    /**
     * DefaultIfEmpty
     */
    public Flux<Integer> switchIfEmpty_bad() {
        return Flux.just(-1, 0, 1)
            .flatMap(id -> {
                if (id < 0) {
                    return Mono.error(new RuntimeException());
                }
                return reactiveOp(id);
            });
    }

    public Flux<Integer> switchIfEmpty_good() {
        return Flux.just(-1, 0, 1)
            .filter(id -> id >= 0)
            .flatMap(this::reactiveOp)
            .switchIfEmpty(Mono.error(new RuntimeException()));
    }

    /**
     * filterWhen inner Publisher가 반환하는 boolean 값으로 필터를 적용하는 오퍼레이터임. true이면 통과 false나 complete이면
     * 차단한다.
     */
    public Flux<Integer> filterWhen_bad() {
        return Flux.just(-1, 0, 1)
            .flatMap(id -> getName()
                .flatMap(name -> {
                    if ("good".equals(name)) {
                        return Mono.empty();
                    }
                    return reactiveOp(id);
                }));
    }

    public Flux<Integer> filterWhen_good() {
        return Flux.just(-1, 0, 1)
            .filterWhen(id -> getName()
                .map(name -> !"good".equals(name))
                .doOnComplete(() -> {
                    System.out.println("############## 1");
                })
            ).flatMap(this::reactiveOp)
            .doOnComplete(() -> System.out.println("############# 2"));
    }

    // filterWhen의 가독성을 높이는 방법, 메서드로 추출해서 사용하는 경우가 많다고함
    public Flux<Integer> filterWhen_better() {
        return Flux.just(-1, 0, 1)
            .filterWhen(this::isNotJohn)
            .flatMap(this::reactiveOp);
    }

    private Flux<Boolean> isNotJohn(Integer id) {
        return getName()
            .map(name -> !"john".equals(name))
            .onErrorReturn(false);
    }

    private Flux<String> getName() {
        return Flux.just("good");
    }

    private Flux<Integer> reactiveOp(int integer) {
        return Flux.just(integer);
    }
}
