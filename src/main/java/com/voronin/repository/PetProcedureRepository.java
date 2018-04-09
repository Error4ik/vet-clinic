package com.voronin.repository;

import com.voronin.domain.PetProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 08.04.2018.
 */
@Repository
public interface PetProcedureRepository extends JpaRepository<PetProcedure, Integer> {
}
