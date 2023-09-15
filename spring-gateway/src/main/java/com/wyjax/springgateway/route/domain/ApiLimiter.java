package com.wyjax.springgateway.route.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("api_limiter")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiLimiter implements Serializable {

    private static final long serialVersionUID = -5132504076641395736L;
    @Id // Indicating that this field is primary key in our database table
    private Long id;

    private String path;
    private String method;

    private int threshold;
    private int ttl;

    private boolean active;
}
