package com.acme.authorization.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "UsersGroupHierarchy")
@IdClass(UsersGroupsHierarchyId.class)
@Data
public class UsersGroupsHierarchyEntity {
    @Id
    @Column(name = "ParentGroup")
    private UUID parentGroupId;
    @Id
    @Column(name = "ChildGroup")
    private UUID childGroupId;
}
