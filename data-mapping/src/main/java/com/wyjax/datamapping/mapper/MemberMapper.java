package com.wyjax.datamapping.mapper;

import com.wyjax.datamapping.domain.Member;
import com.wyjax.datamapping.dto.response.MemberExternalResponseDto;
import com.wyjax.datamapping.dto.response.MemberResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberResponseDto toResponseDto(Member member);

    @Mapping(target = "name", source = "myName")
    MemberExternalResponseDto toExternalResponse(Member member);
}
