package com.njt.upkg.Repository;

import com.njt.upkg.Domain.Project;
import com.njt.upkg.Domain.ProjectState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repozitorijum za klasu {@link Project}
 */
public interface ProjectRepository extends JpaRepository<Project,Long> {
    /**
     * Vraca sve projekte sa datim statusom
     * @param state status projekta klase {@link ProjectState}
     * @return Lista projekata sa datim statusom
     */
    List<Project> findAllByState(ProjectState state);

    /**
     * Vraca sve projekte koji nisu datog statusa
     * @param state status koji se izostavlja klase {@link ProjectState}
     * @return Lista projekata koji nisu datog statusa
     */
    List<Project> findAllByStateNot(ProjectState state);

}
