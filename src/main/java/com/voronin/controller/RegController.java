package com.voronin.controller;

import com.voronin.domain.User;
import com.voronin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Reg controller.
 *
 * @author Alexey Voronin.
 * @since 20.02.2018.
 */
@Controller
public class RegController {

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    /**
     * User registration request.
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView regUser(final User user) {
        ModelAndView view = new ModelAndView();
        User u = this.userService.getByEmail(user.getEmail());
        if (u != null) {
            view.setViewName("login");
            view.addObject("error", true);
            return view;
        }
        view.setViewName("index");
        this.userService.regUser(user);
        return view;
    }
}
