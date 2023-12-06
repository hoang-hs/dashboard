package com.example.s.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ErrResource {

    @JsonProperty("http_code")
    private int httpCode;

    @JsonProperty("message")
    private String message;

    public ErrResource(int httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
