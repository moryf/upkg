package com.njt.upkg.repository;

import com.njt.upkg.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorijum klase {@link Buyer}
 */
public interface BuyerRepository extends JpaRepository<Buyer,Long> {

}
