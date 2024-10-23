package com.acme.authorization.domain.entities_groups;

import com.acme.authorization.domain.entities.EntitiesGroupEntity;
import lombok.Data;

import java.util.List;

@Data
public class EntitiesGroup {
    private EntitiesGroupEntity sourceEntity;
    private EntitiesGroupParent parent;
    private EntitiesGroupEntities entities;
    private EntitiesGroupChildren allChildren;
    private EntitiesGroupDirects directChildren;
    private EntitiesGroupParents allParents;
    private EntitiesGroupPermissions permissions;

    public EntitiesGroup(EntitiesGroupEntity sourceEntity,
                         EntitiesGroupEntities entities,
                         EntitiesGroupDirects entitiesGroupDirect,
                         EntitiesGroupChildren entitiesGroupChildren,
                         EntitiesGroupParents entitiesGroupParents) {
        this.sourceEntity = sourceEntity;
        this.entities = entities;
        this.allChildren = entitiesGroupChildren;
        this.allParents = entitiesGroupParents;
        this.directChildren = entitiesGroupDirect;
    }
    public void delete() {
        this.permissions.deleteAll();
        if(this.parent != null) {
            this.parent.get().removeChild(this);
        }
        this.allParents.removeChild(this);
        this.entities.removeAll();
    }

    public void removeChild(EntitiesGroup entitiesGroup) {
        this.directChildren.remove(entitiesGroup);
    }

    public EntitiesGroup addChild(String entitiesGroupName) {
        throw new RuntimeException();
    }

    public <TEntity> void associateEntity(TEntity feature) {
    }

    public interface EntitiesGroupParent {
        EntitiesGroup get();
    }

    public interface EntitiesGroupEntities {
        List<EntityReference> findAll();
        void removeAll();
    }

    public interface EntitiesGroupDirects {
        List<EntitiesGroup> findAll();
        void remove(EntitiesGroup entitiesGroup);
        int count();
    }

    public interface EntitiesGroupChildren {
        List<EntitiesGroup> findAll();
    }

    public interface EntitiesGroupParents {
        List<EntitiesGroup> findAll();
        void removeChild(EntitiesGroup entitiesGroup);
    }

    public interface EntitiesGroupPermissions {
        void deleteAll();
    }
}
