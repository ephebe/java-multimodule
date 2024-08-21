package com.acme.authorization.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "EntityTypes")
public class EntityTypeEntity {
    @Id
    @Column(name="Id")
    private UUID id;
    @Column(name="Name")
    private String name;
}
