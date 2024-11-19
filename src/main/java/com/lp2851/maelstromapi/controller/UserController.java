package com.lp2851.maelstromapi.controller;

import com.lp2851.maelstromapi.controller.base.CrudController;
import com.lp2851.maelstromapi.controller.base.MaelstromController;
import com.lp2851.maelstromapi.exception.http.PathPayloadMismatchException;
import com.lp2851.maelstromapi.model.UserDto;
import com.lp2851.maelstromapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController extends MaelstromController<UserDto> implements CrudController<UserDto> {
    // todo auth

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Mono<UserDto>> get(UUID id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @Override
    public ResponseEntity<Mono<Page<UserDto>>> getAll() {
        // todo pagination
        return ResponseEntity.ok(userService.findAll(Pageable.unpaged()));
    }

    @Override
    public ResponseEntity<Void> create(UUID id, @Valid UserDto entity) {
        if (!isPathPayloadMatch(id, entity)) {
            throw new PathPayloadMismatchException(id, entity.getId());
        }

        userService.create(entity).block();
        return ResponseEntity.created(getHeaderLocation(entity)).build();
    }

    @Override
    public ResponseEntity<Void> update(UUID id, @Valid UserDto entity) {
        if (!isPathPayloadMatch(id, entity)) {
            throw new PathPayloadMismatchException(id, entity.getId());
        }

        userService.update(entity).block();
        return ResponseEntity.noContent().location(getHeaderLocation(entity)).build();
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
