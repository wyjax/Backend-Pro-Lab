package com.wyjax.springgateway.common.component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Slf4j
@Component
public class CommonObjectMapper {
    private final ObjectMapper objectMapper;

    public CommonObjectMapper() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
        this.objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, false);
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public Object readValue(String data, Class<?> classType) {
        try {
            return objectMapper.readValue(data, classType);
        } catch (JsonProcessingException e) {
            log.error("Failure convert to {}", classType.getSimpleName());
            return null;
        }
    }

    public String writeAsString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("Failure convert to String");
            return null;
        }
    }

    public byte[] writeAsBytes(Object o) {
        try {
            return objectMapper.writeValueAsBytes(o);
        } catch (JsonProcessingException e) {
            log.error("Failure convert to String");
            return new byte[0];
        }
    }

    public Object convertValue(Object o, Class<?> type) {
        try {
            return objectMapper.convertValue(o, type);
        } catch (Exception e) {
            log.error("Failure convert to value");
            return null;
        }
    }
}
