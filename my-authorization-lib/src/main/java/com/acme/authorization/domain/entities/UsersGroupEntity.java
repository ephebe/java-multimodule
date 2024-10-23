package com.acme.authorization.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "UsersGroups")
public class UsersGroupEntity {
    @Id
    @Column(name="Id")
    private UUID id;
    @Column(name="Name")
    private String name;
    @Column(name="Parent")
    private UUID parentId;
}
