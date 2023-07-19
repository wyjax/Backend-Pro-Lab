package com.wyjax.hexagonalarchiexam.member.adapter.in.web;

import com.wyjax.hexagonalarchiexam.member.application.port.in.CreateMemberUseCase;
import com.wyjax.hexagonalarchiexam.member.application.port.in.SearchMemberUseCase;
import com.wyjax.hexagonalarchiexam.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final SearchMemberUseCase searchMemberUseCase;
    private final CreateMemberUseCase createMemberUseCase;

    @GetMapping("/api/member")
    public ResponseEntity<Member> getMember() {
        Member member = searchMemberUseCase.getMember();
        return ResponseEntity.ok(member);
    }

    @PostMapping("/api/member")
    public ResponseEntity<Member> createMember() {
        Member member = createMemberUseCase.saveMember(new Member());
        return ResponseEntity.ok(member);
    }
}