package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.users_groups.UsersGroup;
import com.acme.authorization.domain.users_groups.UsersGroupUser;
import com.acme.authorization.domain.entities.UsersGroupUserEntity;
import com.acme.authorization.infrastructure.repository.UsersGroupUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UsersGroupUsersImpl implements UsersGroup.UsersGroupUsers {
    private final UsersGroupUserRepository repository;

    @Override
    public List<UsersGroupUser> findByUsersGroupId(UUID usersGroupId) {
        return
            repository.findByUsersGroupId(usersGroupId)
                    .stream().map(this::map).toList();
    }

    @Override
    public void removeAll() {

    }

    @Override
    public void add(UsersGroup userGroup,User user) {
        UsersGroupUserEntity entity = new UsersGroupUserEntity();
        entity.setUsersGroupId(userGroup.getId());
        entity.setUserId(user.getSrc().getId());
        repository.save(entity);
    }

    private UsersGroupUser map(UsersGroupUserEntity entity) {
        return null;
    }
}
