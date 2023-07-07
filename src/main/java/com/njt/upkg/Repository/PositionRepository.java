package com.njt.upkg.Repository;

import com.njt.upkg.Domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repozitorijum za klasu {@link Position}
 */
public interface PositionRepository extends JpaRepository<Position,Long> {
    /**
     * Vraca sve pozicije u datom projektu
     * @param projectId id projekta za koji se traze pozicije
     * @return Listu svih pozicija projekta
     */
    List<Position> findAllByProject_Id(Long projectId);

}
