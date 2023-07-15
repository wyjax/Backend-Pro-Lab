package com.wyjax.ratelimiter;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RatelimiterApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void bucket_테스트() {
		// 1분에 10개
		Refill refill = Refill.intervally(10, Duration.ofMinutes(1));
		Bandwidth limit = Bandwidth.classic(10, refill);
		Bucket bucket = Bucket.builder()
				.addLimit(limit)
				.build();
		for (int i = 1; i <= 10; i++) {
			assertTrue(bucket.tryConsume(1));
		}
		assertFalse(bucket.tryConsume(1));
	}
}
