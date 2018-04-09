package com.voronin.services;

import com.voronin.domain.Role;
import com.voronin.domain.User;
import com.voronin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 11.02.2018.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private SecurityService securityService;

    public User save(final User owner) {
        return this.userRepository.save(owner);
    }

    public User getById(final int id) {
        return this.userRepository.findOne(id);
    }

    public List<User> getUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public void removeOwnerById(final int id) {
        this.userRepository.delete(id);
    }

    public User getByEmail(final String name) {
        return this.userRepository.getByEmail(name);
    }

    public void regUser(final User user) {
        final String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(this.roleService.getById(1));
        user.setRoles(roles);
        this.save(user);
        this.securityService.autoLogin(user.getEmail(), password);
    }

    public void update(final User user) {
        User us = this.getById(user.getId());
        us.setFirstName(user.getFirstName());
        us.setLastName(user.getLastName());
        us.setPhoneNumber(user.getPhoneNumber());
        this.userRepository.save(us);
    }
}
