package com.njt.upkg.repository;

import com.njt.upkg.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozitorijum za klasu {@link User}
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * Vraca korisnika sa datim korisnickim imenom i lozinkom
     * @param username korisnicko ime koje se trazi
     * @param password lozinka koja se trazi
     * @return Korisnik sa datim korisnickim imenom i lozinkom
     */
    User findUserByUsernameAndPassword(String username, String password);

}
