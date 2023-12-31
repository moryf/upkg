package com.njt.upkg.repository;

import com.njt.upkg.domain.ProjectOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repozitorijum za klasu {@link ProjectOperation}
 */
public interface ProjectOperationRepository extends JpaRepository<ProjectOperation,Long> {
    /**
     * Vraca sve operacije za dati projekat
     * @param id id projekta za koji se traze operacije
     * @return Lista operacija za dati projekat
     */
    List<ProjectOperation> findAllByProject_Id(Long id);

}
