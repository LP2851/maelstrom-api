package com.lp2851.maelstromapi.repository;

import com.lp2851.maelstromapi.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {
}