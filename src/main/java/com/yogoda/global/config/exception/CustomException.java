package com.yogoda.global.config.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private CustomErrorCode customErrorCode;
    private String detailMessage;

    public CustomException(CustomErrorCode code) {
        super(code.getStatusMessage());
        this.customErrorCode = code;
        this.detailMessage = customErrorCode.getStatusMessage();
    }

    public CustomException(CustomErrorCode code, String detailMessage) {
        super(detailMessage);
        this.customErrorCode = code;
        this.detailMessage = detailMessage;
    }
}
