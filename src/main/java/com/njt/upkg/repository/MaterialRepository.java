package com.njt.upkg.repository;

import com.njt.upkg.domain.Material;
import com.njt.upkg.domain.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repozitorijum za klasu {@link Material}
 */
public interface MaterialRepository extends JpaRepository<Material,Long> {
    /**
     * Pronalazi sve materijale odredjenog tipa
     * @param type tip Materijala klase {@link MaterialType}
     * @return Lista materijala datog tipa
     */
    List<Material> findAllByType(MaterialType type);

}
