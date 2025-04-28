package com.example.notification_api_service.config.feign;

import com.example.notification_api_service.service.security.JwtService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeignRequestInterceptor implements RequestInterceptor {
    private final JwtService jwtService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        final String authorization = HttpHeaders.AUTHORIZATION;
        requestTemplate.header(authorization, "Bearer " + jwtService.generateDefaultToken());
    }
}
