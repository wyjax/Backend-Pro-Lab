package com.wyjax.datamapping.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberInfoResponseDto {

    private String name;
    private Integer age;
    private String address;
}
