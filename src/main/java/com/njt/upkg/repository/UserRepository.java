package com.njt.upkg.repository;

import com.njt.upkg.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozitorijum za klasu {@link User}
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
