package com.wyjax.datamapping.service;

import com.wyjax.datamapping.domain.Member;
import com.wyjax.datamapping.dto.response.MemberResponseDto;
import com.wyjax.datamapping.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public MemberResponseDto getMember() {
        Member member = new Member("eom", 29);
        return MemberMapper.INSTANCE.toResponseDto(member);
    }
}
