package com.njt.upkg.Repository;

import com.njt.upkg.Domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repozitorijum za klasu {@link Worker}
 */
public interface WorkerRepository extends JpaRepository<Worker,Long> {
    /**
     * Vraca sve radnike cije ime sadrzi neki String
     * @param substrName String vrednost koja se pretrazuje
     * @return Lista radnika cije ime sadrzi dati string
     */
    List<Worker> findAllByNameContains(String substrName);
}
