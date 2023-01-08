package com.wyjax.springreactiveredis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableCaching
@Configuration
public class RedisConfig {

    @Bean
    @Primary
    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
        return new LettuceConnectionFactory("localhost", 6379);
    }

    @Bean
    public ReactiveRedisTemplate<String, Object> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        RedisSerializationContext<String, Object> serializationContext =
                RedisSerializationContext.<String, Object>newSerializationContext(redisSerializer)
                        .key(redisSerializer)
                        .value(jsonRedisSerializer)
                        .build();
        return new ReactiveRedisTemplate<>(factory, serializationContext);
    }
    /*
        GenericJackson2JsonRedisSerializer 을 value Serializer 로 사용하지 않는 이유는
        json string으로 redis에 저장시 class 정보가 같이 들어가게 된다. 그래서 저장한 후에 필드 정보가 맞더라도
        class 정보에 맞지 않는다면 deSerialize 시에 문제가 발생하게 된다.
     */

//
//    @Bean
//    public ReactiveRedisTemplate<String, String> customReactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
//                StringRedisSerializer keySerializer = new StringRedisSerializer();
//        Jackson2JsonRedisSerializer<String> valueSerializer = new Jackson2JsonRedisSerializer<>(String.class);
//
//        RedisSerializationContextBuilder<String, String> builder = newSerializationContext(keySerializer);
//        RedisSerializationContext<String, String> context = builder.value(valueSerializer).build();
////        return new ReactiveRedisTemplate<>(factory, context);
//
//
//        return new ReactiveRedisTemplate<>(factory, RedisSerializationContext.string());
//    }

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        return redisTemplate;
//    }
//
//    @Bean
//    public ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
//        StringRedisSerializer keySerializer = new StringRedisSerializer();
//        Jackson2JsonRedisSerializer<String> valueSerializer = new Jackson2JsonRedisSerializer<>(String.class);
//
//        RedisSerializationContextBuilder<String, String> builder = newSerializationContext(keySerializer);
//        RedisSerializationContext<String, String> context = builder.value(valueSerializer).build();
//        return new ReactiveRedisTemplate<>(factory, context);
//    }
}
