package com.njt.upkg.Repository;
import com.njt.upkg.Domain.ProjectMaterial;
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

    /**
     * Vraca listu materijala utrosenog za datu poziciju
     * @param id id Pozicije za koju se trazi utrosen materijal
     * @return Lista utrosenog materijala za datu poziciju
     */
    List<ProjectMaterial> findAllByPosition_Id(Long id);
}
