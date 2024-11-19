package com.lp2851.maelstromapi.service;

import com.lp2851.maelstromapi.entity.User;
import com.lp2851.maelstromapi.exception.http.ConflictException;
import com.lp2851.maelstromapi.exception.http.NotFoundException;
import com.lp2851.maelstromapi.model.UserDto;
import com.lp2851.maelstromapi.repository.UserRepository;
import com.lp2851.maelstromapi.service.base.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService implements CrudService<User, UserDto> {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Mono<UserDto> getById(UUID id) {
        return userRepository.findById(id)
                .map(UserDto::create)
                .map(Mono::just)
                .orElseThrow(() -> new NotFoundException(User.class, id));
    }

    @Override
    @Transactional
    public Mono<Page<UserDto>> findAll(Pageable pageable) {
        return Mono.just(userRepository.findAll(pageable)
                .map(UserDto::create));
    }

    @Override
    @Transactional
    public Mono<UserDto> create(UserDto dto) {
        if (userRepository.existsByIdOrEmailOrUsername(dto.getId(), dto.getEmail(), dto.getUsername())) {
            throw new ConflictException("User already exists");
        }

        var user = toEntity(dto);
        user = userRepository.saveAndFlush(user);
        return Mono.just(UserDto.create(user));
    }

    @Override
    @Transactional
    public Mono<UserDto> update(UserDto dto) {
        return userRepository.findById(dto.getId())
                .map(u -> toEntity(u, dto))
                .map(userRepository::save)
                .map(UserDto::create)
                .map(Mono::just)
                .orElseThrow(() -> new NotFoundException(User.class, dto.getId()));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        // todo turn this into soft delete
        userRepository.findById(id).ifPresent(userRepository::delete);
    }

    @Override
    public User toEntity(User entity, UserDto dto) {
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    @Override
    public User toEntity(UserDto dto) {
        var user = new User();
        user.setId(dto.getId());
        return toEntity(user, dto);
    }
}
