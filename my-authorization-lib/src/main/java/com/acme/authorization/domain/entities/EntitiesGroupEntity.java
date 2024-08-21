package com.acme.authorization.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "EntitiesGroups")
public class EntitiesGroupEntity {
    @Id
    @Column(name="Id")
    private UUID id;
    @Column(name="Name")
    private String name;
    @Column(name="DefaultOrder")
    private Integer defaultOrder;
    @Column(name="Parent")
    private UUID parentId;
}
