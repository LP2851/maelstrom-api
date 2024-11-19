package com.lp2851.maelstromapi.controller.base;

import com.lp2851.maelstromapi.model.MaelstromDto;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

public abstract class MaelstromController<E extends MaelstromDto> {
    protected URI getHeaderLocation(E dto) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand(dto.getId())
                .toUri();
    }

    protected boolean isPathPayloadMatch(UUID id, E dto) {
        return id.equals(dto.getId());
    }
}
