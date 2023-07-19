package com.wyjax.hexagonalarchiexam.member.application.port.in;

import com.wyjax.hexagonalarchiexam.member.domain.Member;

public interface CreateMemberUseCase {

    Member saveMember(Member member);
}
