package br.com.imerljak.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(getPrincipal());
    }

    private String getPrincipal() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }
}
