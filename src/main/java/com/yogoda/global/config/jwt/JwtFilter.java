package com.yogoda.global.config.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Log4j2
public class JwtFilter extends GenericFilterBean {

    // JWT 필터 로직은 서블릿 처리
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
}
