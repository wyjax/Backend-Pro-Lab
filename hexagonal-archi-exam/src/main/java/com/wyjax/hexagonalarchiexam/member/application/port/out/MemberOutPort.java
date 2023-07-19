package com.wyjax.hexagonalarchiexam.member.application.port.out;

import com.wyjax.hexagonalarchiexam.member.domain.Member;

public interface MemberOutPort {

    Member save(Member member);

    Member get(Long memberId);
}
