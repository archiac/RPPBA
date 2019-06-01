package shop.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    MANAGER, BOSS;

    @Override
    public String getAuthority() {
        return name();
    }
}
