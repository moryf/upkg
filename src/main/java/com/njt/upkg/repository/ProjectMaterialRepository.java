package com.njt.upkg.repository;
import com.njt.upkg.domain.ProjectMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repzitorijum za klasu {@link ProjectMaterial}
 */
public interface ProjectMaterialRepository extends JpaRepository<ProjectMaterial,Long> {
    /**
     * Vraca sav materijal utrosen za dati projekat
     * @param id id projekta za koji se trazi utrosen materijal
     * @return Lista utrosenog materijala za dati projekat
     */
    List<ProjectMaterial> findAllByProject_Id(Long id);

}
