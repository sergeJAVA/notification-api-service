package com.example.notification_api_service.model.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenData {
    private Long id;
    private String username;
    private String token;
    private List<? extends GrantedAuthority> authorities;
}
