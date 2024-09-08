package com.user.manager.repository;

import com.user.manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameOrEmail(String userName, String email);
    Boolean existsByEmail(String email);

}
