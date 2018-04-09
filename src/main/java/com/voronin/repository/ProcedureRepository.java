package com.voronin.repository;

import com.voronin.domain.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Procedure repository.
 *
 * @author Alexey Voronin.
 * @since 08.03.2018.
 */
@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {

    Procedure findByName(final String name);
}
