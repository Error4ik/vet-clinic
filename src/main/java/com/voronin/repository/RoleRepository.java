package com.voronin.repository;

import com.voronin.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Role repository.
 *
 * @author Alexey Voronin.
 * @since 11.02.2018.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
