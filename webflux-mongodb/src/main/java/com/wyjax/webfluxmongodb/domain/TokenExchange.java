package com.wyjax.webfluxmongodb.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "list")
public class TokenExchange {

    @Id
    private Long id;
    private String opaqueToken;
    private String originalToken;
}
