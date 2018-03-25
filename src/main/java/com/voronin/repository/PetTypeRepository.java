package com.voronin.repository;

import com.voronin.domain.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 11.02.2018.
 */
@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
    PetType getByType(final String type);
}
