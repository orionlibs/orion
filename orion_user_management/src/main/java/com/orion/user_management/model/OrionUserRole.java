package com.orion.user_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrionUserRole implements GrantedAuthority
{
    public static final String Administrator = "ROLE_ADMINISTRATOR";
    public static final String User = "ROLE_USER";
    public static final String Anonymous = "ROLE_ANONYMOUS";
    public static final String Customer = "ROLE_CUSTOMER";
    public static final String Business = "ROLE_BUSINESS";
    private String authority;
}