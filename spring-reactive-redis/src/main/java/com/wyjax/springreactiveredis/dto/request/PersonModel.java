package com.wyjax.springreactiveredis.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonModel {
    private String uuid;
    private String name;
    private int age;
}
