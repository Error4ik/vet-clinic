package com.voronin.repository;

import com.voronin.domain.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Imgae repository
 *
 * @author Alexey Voronin.
 * @since 11.02.2018.
 */
@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {
}
