package com.njt.upkg.Repository;

import com.njt.upkg.Domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorijum klase {@link Buyer}
 */
public interface BuyerRepository extends JpaRepository<Buyer,Long> {

}
