package com.lp2851.maelstromapi.exception.http;

import com.lp2851.maelstromapi.exception.MaelstromHandledException;
import org.springframework.http.HttpStatus;

public class ConflictException extends MaelstromHandledException {
    public ConflictException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
