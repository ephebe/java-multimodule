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
    @Column(name = "AncestorGroup")
    private UUID ancestorId;
    @Id
    @Column(name = "DescendantGroup")
    private UUID descendantId;

    public UsersGroupsHierarchyEntity() {

    }

    public UsersGroupsHierarchyEntity(UUID ancestorId,UUID descendantId) {
        this.ancestorId = ancestorId;
        this.descendantId = descendantId;
    }
}
