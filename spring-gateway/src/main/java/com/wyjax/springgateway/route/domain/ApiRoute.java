package com.wyjax.springgateway.route.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("api_route")
@NoArgsConstructor
@AllArgsConstructor
public class ApiRoute {

    @Id
    private Long id;

    private String uri;
    private String path;
    private String method;
    private String predicate;
}
