package com.wyjax.springgateway;

//@Service
//@RequiredArgsConstructor
//public class ApiLimiterKeyResolver implements KeyResolver {
//    private final ApiLimiterService apiLimiterService;
//    private final ObjectHelper objectHelper;
//
//    @Override
//    public Mono<String> resolve(ServerWebExchange exchange) {
//        String path = exchange.getRequest().getPath().value();
//        String method = exchange.getRequest().getMethodValue();
//        return apiLimiterService.getApiLimiter(path, method)
//                .doOnNext(apiLimiter -> apiLimiter.setPath(path))
//                .map(objectHelper::toStringBase64);
//    }
//}
