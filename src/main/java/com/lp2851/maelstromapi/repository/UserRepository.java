package com.lp2851.maelstromapi.repository;

import com.lp2851.maelstromapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByIdOrEmailOrUsername(UUID id, String email, String username);
}
