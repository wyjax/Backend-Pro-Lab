#  레디스 지원
레디시는 key-value 저장소이다. memcacheddㅘ 유사하지만 데이터 세트는 휘발성이 아니다. 그리고 다양한 데이터 세트를 제공한다.
문자열, hash, set 등등

## 필요 라이브러리 
- spring-data-redis

## 10.4 레디스 연결
Redis와 spring을 사용할 때는 RedisConnection 인터페이스만 사용해야한다

## Redis java 커넥션
- Jedis : 커뮤니티 기반 커넥터
- Lettuce : netty 기반 오픈소스 커넥터 

## RedisTemplate 작업
- 