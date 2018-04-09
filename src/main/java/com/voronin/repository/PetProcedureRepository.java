package com.voronin.repository;

import com.voronin.domain.PetProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Pet procedure repository.
 *
 * @author Alexey Voronin.
 * @since 08.04.2018.
 */
@Repository
public interface PetProcedureRepository extends JpaRepository<PetProcedure, Integer> {
}
