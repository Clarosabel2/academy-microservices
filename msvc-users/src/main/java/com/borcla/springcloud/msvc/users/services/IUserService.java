package com.borcla.springcloud.msvc.users.services;

import com.borcla.springcloud.msvc.users.models.entitiy.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(UUID id);
    User save(User user);
    void deleteById(UUID id);
    User update(UUID id, User user);
}
