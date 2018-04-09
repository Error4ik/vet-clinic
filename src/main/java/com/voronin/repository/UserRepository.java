package com.voronin.repository;

import com.voronin.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository.
 *
 * @author Alexey Voronin.
 * @since 11.02.2018.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User getByEmail(final String name);
}
