package com.wyjax.datamapping.mapper;

import com.wyjax.datamapping.domain.Member;
import com.wyjax.datamapping.dto.response.MemberExternalResponseDto;
import com.wyjax.datamapping.dto.response.MemberInfoResponseDto;
import com.wyjax.datamapping.dto.response.MemberResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberResponseDto toResponseDto(Member member);

    default MemberResponseDto toCustomResponseDto(Member member) {
        MemberResponseDto dto = new MemberResponseDto();
        dto.setAge(member.getAge());
        dto.setName(member.getName());
        return dto;
    }

    @Mapping(target = "myName", source = "name")
    @Mapping(target = "myAge", source = "age")
    MemberExternalResponseDto toExternalResponse(Member member);

    MemberInfoResponseDto toMemberInfoResponse(Member member, String address);
}