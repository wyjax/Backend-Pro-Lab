package com.wyjax.datamapping.dto.mapper;

import com.wyjax.datamapping.dto.Member;
import com.wyjax.datamapping.dto.MemberResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberResponseDto toResponseDto(Member member);
}
