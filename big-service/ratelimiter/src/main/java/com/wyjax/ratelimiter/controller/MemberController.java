package com.wyjax.ratelimiter.controller;

import com.wyjax.ratelimiter.dto.MemberDto;
import com.wyjax.ratelimiter.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestController
@RequiredArgsConstructor
public class MemberController  {
    private final MemberService memberService;

    @GetMapping("/api/members")
    public List<MemberDto> getMembers() {
        return memberService.getMembers();
    }
}
