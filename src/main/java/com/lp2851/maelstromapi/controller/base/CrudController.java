package com.lp2851.maelstromapi.controller.base;

import com.lp2851.maelstromapi.model.MaelstromDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CrudController<E extends MaelstromDto> {
    @GetMapping("/{id}")
    ResponseEntity<Mono<E>> get(@PathVariable("id") UUID id);

    @GetMapping
    ResponseEntity<Mono<Page<E>>> getAll();

    @PostMapping("/{id}")
    ResponseEntity<Void> create(@PathVariable("id") UUID id, @RequestBody E entity);

    @PutMapping("/{id}")
    ResponseEntity<Void> update(@PathVariable("id") UUID id, @RequestBody E entity);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") UUID id);
}
