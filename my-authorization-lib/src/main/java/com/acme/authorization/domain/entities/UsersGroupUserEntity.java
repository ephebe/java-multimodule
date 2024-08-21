package com.acme.authorization.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@IdClass(UsersGroupUserId.class)
@Table(name = "UsersGroupUser")
public class UsersGroupUserEntity {
    @Id
    @Column(name="UsersGroup")
    private UUID usersGroupId;
    @Id
    @Column(name="User")
    private UUID userId;

    public UsersGroupUserEntity() {

    }
}
