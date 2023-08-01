package com.wyjax.datamapping.mapper;

import com.wyjax.datamapping.domain.Member;
import com.wyjax.datamapping.dto.response.MemberExternalResponseDto;
import com.wyjax.datamapping.dto.response.MemberInfoResponseDto;
import com.wyjax.datamapping.dto.response.MemberResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class MemberMapperTest {

    @Test
    void mapperSetterTest() {
        // given
        Member member = new Member("엄정기", 29);
        // when
        MemberResponseDto dto = MemberMapper.INSTANCE.toResponseDto(member);
        // then
        Assertions.assertThat(dto.getName()).isEqualTo(member.getName());
        Assertions.assertThat(dto.getAge()).isEqualTo(member.getAge());
    }

    @Test
    void mapperCustomMethod() {
        // given
        Member member = new Member("엄정기", 29);
        // when
        MemberResponseDto dto = MemberMapper.INSTANCE.toCustomResponseDto(member);
        // then
        Assertions.assertThat(dto.getName()).isEqualTo(member.getName());
        Assertions.assertThat(dto.getAge()).isEqualTo(member.getAge());
    }

    @Test
    void mapperNoSetterTest() {
        // given
        Member member = new Member("엄정기", 29);
        // when
        MemberExternalResponseDto dto = MemberMapper.INSTANCE.toExternalResponse(member);
        // then
        Assertions.assertThat(dto.getMyName()).isEqualTo(member.getName());
        Assertions.assertThat(dto.getMyAge()).isEqualTo(member.getAge());
    }

    @Test
    void 여러_파라미터주입() {
        // given
        Member member = new Member("엄정기", 29);
        String address = "경기도 용인시 기흥구";
        // when
        MemberInfoResponseDto dto = MemberMapper.INSTANCE.toMemberInfoResponse(member, address);
        // then
        Assertions.assertThat(dto.getName()).isEqualTo(member.getName());
        Assertions.assertThat(dto.getAge()).isEqualTo(member.getAge());
        Assertions.assertThat(dto.getAddress()).isEqualTo(address);
    }
}