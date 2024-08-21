package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.User;
import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.domain.UsersGroupUser;
import com.acme.authorization.domain.entities.UsersGroupUserEntity;
import com.acme.authorization.infrastructure.repository.UsersGroupUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupUsersImpl implements UsersGroup.UsersGroupUsers {
    private final UUID usersGroupId;
    private final UsersGroupUserRepository repository;

    @Override
    public List<UsersGroupUser> findAll() {
        return
            repository.findByUsersGroupId(usersGroupId)
                    .stream().map(repository::build).toList();
    }

    @Override
    public void removeAll() {

    }

    @Override
    public void add(User user) {
        UsersGroupUserEntity entity = new UsersGroupUserEntity();
        entity.setUsersGroupId(this.usersGroupId);
        entity.setUserId(user.getSrc().getId());
        repository.save(entity);
    }


}
