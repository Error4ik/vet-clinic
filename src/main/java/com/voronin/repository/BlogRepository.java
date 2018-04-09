package com.voronin.repository;

import com.voronin.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 03.04.2018.
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findAllByOrderByDateAsc();

    Blog findById(final int id);
}
