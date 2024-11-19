package com.lp2851.maelstromapi.service.base;

import com.lp2851.maelstromapi.entity.BaseEntity;
import com.lp2851.maelstromapi.model.MaelstromDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CrudService<E extends BaseEntity, D extends MaelstromDto> {
    Mono<D> getById(UUID id);
    Mono<Page<D>> findAll(Pageable pageable);
    Mono<D> create(D dto);
    Mono<D> update(D dto);
    void delete(UUID id);
    E toEntity(D dto);
    E toEntity(E entity, D dto);
}
