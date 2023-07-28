package com.wyjax.datamapping.controller;

import com.wyjax.datamapping.dto.MemberResponseDto;
import com.wyjax.datamapping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/api/member")
    public MemberResponseDto getMember() {
        return memberService.getMember();
    }
}
