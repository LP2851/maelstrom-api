package com.lp2851.maelstromapi.exception.http;

import com.lp2851.maelstromapi.exception.MaelstromHandledException;
import org.springframework.http.HttpStatus;

public class NotImplementedException extends MaelstromHandledException {
    public NotImplementedException(String message) {
        super(message, HttpStatus.NOT_IMPLEMENTED);
    }

    public NotImplementedException() {
      super("Not implemented", HttpStatus.NOT_IMPLEMENTED);
    }
}
