package com.borcla.springcloud.msvc.users.repositories;

import com.borcla.springcloud.msvc.users.models.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {

}
