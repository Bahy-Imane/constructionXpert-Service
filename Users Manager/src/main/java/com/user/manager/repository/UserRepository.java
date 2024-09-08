package com.user.manager.repository;

import com.user.manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameOrEmail(String email,String userName);
    Boolean existsByEmail(String email);

}
