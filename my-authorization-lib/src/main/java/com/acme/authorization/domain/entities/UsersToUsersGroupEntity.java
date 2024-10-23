package com.acme.authorization.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@IdClass(UsersGroupUserId.class)
@Table(name = "UsersToUsersGroups")
public class UsersToUsersGroupEntity {
    @Id
    @Column(name="UsersGroup")
    private UUID usersGroupId;
    @Id
    @Column(name="User")
    private UUID userId;

    public UsersToUsersGroupEntity() {

    }
}
