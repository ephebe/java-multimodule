package com.acme.authorization.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.UUID;

@Data
@Entity
@Table(name = "Permissions")
public class PermissionEntity {
    @Id
    @Column(name="Id")
    private UUID id;
    @Column(name="EntitySecurityKey")
    private UUID entitySecurityKey;
    @Column(name="Allow")
    private Boolean allow;
    @Column(name="Level")
    private int level;
    @Column(name="EntityTypeName")
    private String entityTypeName;
    @Column(name="Operation")
    private UUID operationId;
    @Column(name="User")
    private UUID userId;
    @Column(name="UsersGroup")
    private UUID usersGroupId;
    @Column(name="EntitiesGroup")
    private UUID entitiesGroupId;


    public void SetEntityType(Type type)
    {
        entityTypeName = type.getTypeName();
    }
}
