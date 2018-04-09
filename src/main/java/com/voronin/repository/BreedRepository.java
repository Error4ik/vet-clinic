package com.voronin.repository;

import com.voronin.domain.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Breed repository.
 *
 * @author Alexey Voronin.
 * @since 11.02.2018.
 */
@Repository
public interface BreedRepository extends JpaRepository<Breed, Long>{
    List<Breed> getBreedsByTypeId(final int id);

    Breed getByName(final String name);
}
