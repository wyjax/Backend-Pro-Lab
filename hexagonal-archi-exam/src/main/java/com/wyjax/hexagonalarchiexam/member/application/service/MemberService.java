package com.wyjax.hexagonalarchiexam.member.application.service;

import com.wyjax.hexagonalarchiexam.member.application.port.in.CreateMemberUseCase;
import com.wyjax.hexagonalarchiexam.member.application.port.out.MemberOutPort;
import com.wyjax.hexagonalarchiexam.member.application.port.in.SearchMemberUseCase;
import com.wyjax.hexagonalarchiexam.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements CreateMemberUseCase, SearchMemberUseCase {
    // MemberService 는 port의 adapter가 된다

    private final MemberOutPort memberOutPort;

    @Override
    public Member saveMember(Member member) {
        return memberOutPort.save(member);
    }

    @Override
    public Member getMember() {
        return memberOutPort.get(1L);
    }
}
