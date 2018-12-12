package br.com.imerljak.vendor.jpa.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(getPrincipal());
    }

    private String getPrincipal() {
        return Optional.ofNullable(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication())
                .map(Principal::getName)
                .orElse("public");
    }
}
