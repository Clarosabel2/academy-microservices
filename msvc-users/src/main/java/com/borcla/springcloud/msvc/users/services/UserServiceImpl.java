package com.borcla.springcloud.msvc.users.services;

import com.borcla.springcloud.msvc.users.models.entitiy.User;
import com.borcla.springcloud.msvc.users.repositories.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public User update(UUID id, User user) {
        User userUpdate = userRepository.findById(id).orElse(null);
        if (userUpdate == null) {
            throw new RuntimeException("User not found");
        }

        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setUsername(user.getUsername());
        return userRepository.save(userUpdate);
    }
}
