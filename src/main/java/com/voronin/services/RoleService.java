package com.voronin.services;

import com.voronin.domain.Role;
import com.voronin.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Role service.
 *
 * @author Alexey Voronin.
 * @since 11.02.2018.
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(final Role role) {
        return this.roleRepository.save(role);
    }

    public Role getById(final int id) {
        return this.roleRepository.findOne(id);
    }

    public List<Role> getRoles() {
        return (List<Role>) this.roleRepository.findAll();
    }

    public void removeById(final int id) {
        this.roleRepository.delete(id);
    }
}
