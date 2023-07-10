package com.njt.upkg.repository;

import com.njt.upkg.domain.Project;
import com.njt.upkg.domain.ProjectState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repozitorijum za klasu {@link Project}
 */
public interface ProjectRepository extends JpaRepository<Project,Long> {


}
