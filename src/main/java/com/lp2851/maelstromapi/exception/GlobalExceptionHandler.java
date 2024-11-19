package com.lp2851.maelstromapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MaelstromHandledException.class)
    public ResponseEntity<Map<String, String>> handleMaelstromHandledException(MaelstromHandledException ex) {
        return ex.getResponse();
    }
}
