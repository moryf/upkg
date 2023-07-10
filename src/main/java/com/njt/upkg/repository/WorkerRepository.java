package com.njt.upkg.repository;

import com.njt.upkg.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repozitorijum za klasu {@link Worker}
 */
public interface WorkerRepository extends JpaRepository<Worker,Long> {
}
