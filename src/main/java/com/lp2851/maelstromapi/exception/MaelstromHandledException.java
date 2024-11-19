package com.lp2851.maelstromapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Getter
public class MaelstromHandledException extends RuntimeException {

    protected final HttpStatus httpStatus;

    public MaelstromHandledException(String message) {
        super(message);
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public MaelstromHandledException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public final ResponseEntity<Map<String, String>> getResponse() {
        return ResponseEntity
                .status(httpStatus)
                .body(Map.of("message", getMessage()));
    }
}
