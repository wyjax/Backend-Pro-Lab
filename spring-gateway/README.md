# Spring API Gateway

--------------------------
### 🔸사용 기술스택
- Spring Cloud Gateway (Zuul은 spring에서 공식 지원이 안됨)
- Webflux (성능상 이점을 가져다 줄 것으로 생각)

### 🔸기능
- 리소스 서버로 Routing
- 인증(계정) 서버로 요청 (public, private 나눠서)
- 적절한 로깅 (요청서버와 원격서버를 중계해주는 만큼 기록은 정확하고 이해하기 쉬워야 한다)


### Spring Cloud 게이트웨이는  webflux, project reactor를 기반으로 한다.

- Route : 구성요소, ID, 대상 uri로 정함
- Predicate : java 8에서 포함되는 기술이다.
- Filter :

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0ea3653e-34cf-49ca-abb2-617d0d77eb62/Untitled.png)

### Webflux

**RouteLocator**

routeLocator들이 있는데 Java DSL로 정의된 route들에 대한 정보를 가지고 있는 bean 객체

- RouteDefinitionRouteLocator
    
    ReouteDefinitionLocator로 부터 route들을 로드할 수  있는 RouteLocator
    
- CompositeRouteLocator
    
    여러 개의 RouteLocator들을 delegates 변수로 가지고 있다
    
- CachingRouteLocator
    
    입력 받은 RouteLocator를 delegate로 가지고 있음
    
    CacheFlux에서 CACHE_KEY를 사용하여 매칭 값이 있으면 해당 값을 멤버 변수로 저장한다. 없을 경우 delegate로 가지는 RouteLocatro에서 Flux<Route>를 가져와서 정렬하여 저장

- RoutePredicateHandlerMapping
    여기서 알맞은 predicate 맞는거 가져옴

[GatewayFilterAdapter{delegate=org.springframework.cloud.gateway.filter.NettyWriteResponseFilter@486e9d1d}, order = -1]
[GatewayFilterAdapter{delegate=org.springframework.cloud.gateway.filter.ForwardPathFilter@67e0fd6d}, order = 0]
[[RewritePath /api/good/(?<segment>.*) = '/api/${segment}'], order = 1]
[GatewayFilterAdapter{delegate=org.springframework.cloud.gateway.filter.RouteToRequestUrlFilter@5e5ddfbc}, order = 10000]

