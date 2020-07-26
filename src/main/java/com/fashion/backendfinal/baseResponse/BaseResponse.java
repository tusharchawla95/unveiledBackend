package com.fashion.backendfinal.baseResponse;

import lombok.Data;

@Data
public class BaseResponse {

    private int statusCode;
    private String statusMessage;
    private Object data;

    public BaseResponse(int statusCode, String statusMessage, Object data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
    }

    public BaseResponse(int statusCode, String statusMessage) {
        this(statusCode, statusMessage, null);
    }
}