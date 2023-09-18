package com.njt.upkg.repository;

import com.njt.upkg.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repozitorijum za klasu {@link User}
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
