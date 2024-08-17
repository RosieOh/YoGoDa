package com.yogoda.global.config.exception;

import co.elastic.clients.elasticsearch.nodes.Http;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.yogoda.global.config.exception.CustomErrorCode.INTERNAL_SERVER_ERROR;
import static com.yogoda.global.config.exception.CustomErrorCode.INVALID_REQUEST;

@Log4j2
@RestControllerAdvice
public class CustomExceptionHandler {

    // 전역 예외처리
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomException.class)
    public CustomErrorResponse handleException(
            CustomException e,
            HttpServletRequest request
    ) {
        log.error("errorCode : {}, url {}, message : {}",
                  e.getCustomErrorCode(), request.getRequestURI(), e.getDetailMessage());

        return CustomErrorResponse.builder()
                .status(e.getCustomErrorCode())
                .statusMessage(e.getDetailMessage())
                .build();
    }

    // 예외처리가 쉽지 않은 예외처리를 예외처리 해주는 메소드
    @ExceptionHandler(value = {
            HttpRequestMethodNotSupportedException.class, // get, post 등 메소드(요청)가 잃치 하지 않았을 경우
            MethodArgumentNotValidException.class,        // 컨트롤러 내부 진입 전에 Validation으로 발생하는 에러를 캐치하는 역할
    })

    public CustomErrorResponse handleBadRequest(
            Exception e, HttpServletRequest request
    ) {
        log.error("url {}, message: {}",
                  request.getRequestURI(), e.getMessage());

        return CustomErrorResponse.builder()
                .status(INVALID_REQUEST)
                .statusMessage(INVALID_REQUEST.getStatusMessage())
                .build();
    }

    // 알 수 없거나 알아내기 힘든 오류의 최후 예외처리
    @ExceptionHandler(Exception.class)
    public CustomErrorResponse handleException(
            Exception e, HttpServletRequest request
    ) {
        log.error("url {}, message: {}",
                request.getRequestURI(), e.getMessage());

        return CustomErrorResponse.builder()
                .status(INTERNAL_SERVER_ERROR)
                .statusMessage(INVALID_REQUEST.getStatusMessage())
                .build();
    }
}
