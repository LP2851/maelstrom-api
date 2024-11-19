package com.lp2851.maelstromapi.exception.http;

import com.lp2851.maelstromapi.entity.BaseEntity;
import com.lp2851.maelstromapi.exception.MaelstromHandledException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class NotFoundException extends MaelstromHandledException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(Class<? extends BaseEntity> clazz, UUID id) {
        super("Not found: " + clazz.getSimpleName() + "(" + id + ")", HttpStatus.NOT_FOUND);
    }
}
