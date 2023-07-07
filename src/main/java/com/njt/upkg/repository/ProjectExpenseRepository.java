package com.njt.upkg.repository;

import com.njt.upkg.domain.ProjectExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repozitorijum za klasu {@link ProjectExpense}
 */
public interface ProjectExpenseRepository extends JpaRepository<ProjectExpense,Long> {
    /**
     * Vraca sve Troskove za dati projekat
     * @param id id projekta za koji se traze troskovi
     * @return Lista svih troskova za dati projekat
     */
    List<ProjectExpense> findAllByProject_Id(Long id);

    /**
     * Vraca sve troskove za datu poziciju
     * @param id id Pozicije za koju se traze troskovi
     * @return Lista svih troskova za datu poziciju
     */
    List<ProjectExpense> findAllByPosition_Id(Long id);

    /**
     * Vraca sve troskove za datu operaciju
     * @param id id operacije za koju se traze troskovi
     * @return Lista troskova za datu operaciju
     */
    List<ProjectExpense> findAllByOperation_Id(Long id);
}
