package com.wyjax.springreactiveredis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CacheModel {
    private String key;
    private String value;
}
