package com.lp2851.maelstromapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lp2851.maelstromapi.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements MaelstromDto {
    @NotNull
    private UUID id;

    @NotNull
    @Size(max = 255)
    private String username;

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String firstName;

    @NotNull
    @Size(max = 255)
    private String lastName;

    @NotNull
    @Size(max = 16)
    private String phone;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int followerCount;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int followingCount;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int postCount;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant createdAt;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant updatedAt;

    public static UserDto create(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .followerCount(user.getFollows())
                .followingCount(user.getFollowing().size())
                .postCount(user.getPosts().size())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
