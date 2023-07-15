package com.wyjax.ratelimiter.service;

import com.wyjax.ratelimiter.dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    public List<MemberDto> getMembers() {
        List<MemberDto> members = new ArrayList<>();
        members.add(new MemberDto("엄정기"));
        members.add(new MemberDto("김정기"));
        return members;
    }
}
