package com.voronin.controller;

import com.voronin.domain.Breed;
import com.voronin.domain.PetType;
import com.voronin.domain.Role;
import com.voronin.domain.User;
import com.voronin.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 16.02.2018.
 */
@Controller
public class TestController {

    @Autowired
    private BreedService breedService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PetTypeService typeService;

    @Autowired
    private UserService userService;

    @Autowired
    private PetService petService;

    @RequestMapping("/")
    public ModelAndView getIndex() {
        ModelAndView view = new ModelAndView();
        view.addObject("pets", this.petService.getPets().subList(0, 6));
        view.setViewName("index");
        return view;
    }

    @RequestMapping("/breeds")
    public @ResponseBody
    List<Breed> getAllBreeds() {
        return this.breedService.getBreads();
    }

    @RequestMapping("/roles")
    public @ResponseBody
    List<Role> getRoles() {
        return this.roleService.getRoles();
    }

    @RequestMapping("/pettype")
    public @ResponseBody
    List<PetType> getTypes() {
        return this.typeService.getTypes();
    }

    @RequestMapping("/user")
    public ModelAndView User(final Principal principal) {
        final ModelAndView view = new ModelAndView("user");
        User user = this.userService.getByEmail(principal.getName());
        view.addObject("user", user);
        return view;
    }
}
