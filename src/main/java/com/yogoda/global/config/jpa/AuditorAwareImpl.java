package com.yogoda.global.config.jpa;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;

import java.util.Optional;

@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware<String> {

    private final HttpServletRequest request;

    @Override
    public Optional<String> getCurrentAuditor() {
        String modifiedBy = request.getRequestURI();
        if(!StringUtils.hasText(modifiedBy)) {
            modifiedBy = "unknown";
        }
        // 구현체를 Optional 형태로 반환
        return Optional.of(modifiedBy);
    }
}
