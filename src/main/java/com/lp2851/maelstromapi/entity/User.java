package com.lp2851.maelstromapi.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @NotNull
    @Size(max = 255)
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Size(max = 255)
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Size(max = 255)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(max = 255)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Size(max = 16)
    @Column(name = "phone", nullable = false, length = 16)
    private String phone;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "follows", nullable = false)
    private int follows;

    @NotNull
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "user")
    private Set<Follow> followedBy = new LinkedHashSet<>();

    @OneToMany(mappedBy = "followedUser")
    private Set<Follow> following = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new LinkedHashSet<>();
}