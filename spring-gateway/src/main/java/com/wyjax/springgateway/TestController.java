package com.wyjax.springgateway;

import com.wyjax.springgateway.model.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/api/member")
    public Mono<Member> getMember() {
        return Mono.just(new Member("dwd", 20));
    }

    @GetMapping("/api/members")
    public Flux<Member> getMembers() {
        List<Member> members = new ArrayList<>();
        members.add(new Member("younghee", 20));
        members.add(new Member("minsu", 22));
        return Flux.fromIterable(members);
    }
}
