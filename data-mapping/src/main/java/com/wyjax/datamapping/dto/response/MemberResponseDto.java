package com.wyjax.datamapping.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter // setter는 무조건 있어야 되나보다
@ToString
@NoArgsConstructor
public class MemberResponseDto {

    private String name;
    private int age;
}
