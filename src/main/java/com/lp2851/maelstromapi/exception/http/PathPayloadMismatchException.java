package com.lp2851.maelstromapi.exception.http;

import com.lp2851.maelstromapi.exception.MaelstromHandledException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class PathPayloadMismatchException extends MaelstromHandledException {
    public PathPayloadMismatchException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public PathPayloadMismatchException(UUID pathId, UUID payloadId) {
        super("Path id: " + pathId + " does not match payload id: " + payloadId, HttpStatus.BAD_REQUEST);
    }
}
