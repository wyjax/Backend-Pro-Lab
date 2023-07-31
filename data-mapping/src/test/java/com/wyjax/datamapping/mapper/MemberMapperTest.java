package com.wyjax.datamapping.mapper;

import com.wyjax.datamapping.domain.Member;
import com.wyjax.datamapping.dto.response.MemberExternalResponseDto;
import com.wyjax.datamapping.dto.response.MemberInfoResponseDto;
import com.wyjax.datamapping.dto.response.MemberResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class MemberMapperTest {

    @Test
    void mapperSetterTest() {
        Member member = new Member("엄정기", 29);
        MemberResponseDto dto = MemberMapper.INSTANCE.toResponseDto(member);
        System.out.println(dto);
    }

    @Test
    void mapperNoSetterTest() {
        Member member = new Member("엄정기", 29);
        MemberExternalResponseDto dto = MemberMapper.INSTANCE.toExternalResponse(member);
        System.out.println(dto);
    }

    @Test
    void 여러_파라미터주입() {
        Member member = new Member("엄정기", 29);
        String address = "경기도 용인시 기흥구";
        MemberInfoResponseDto dto = MemberMapper.INSTANCE.toMemberInfoResponse(member, address);
        System.out.println(dto);
    }
}