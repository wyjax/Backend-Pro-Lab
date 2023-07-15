package com.wyjax.ratelimiter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {
    private String name;

    public MemberDto(String name) {
        this.name = name;
    }
}
