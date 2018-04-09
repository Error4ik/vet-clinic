package com.voronin.controller;

import com.voronin.domain.User;
import com.voronin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User controller.
 *
 * @author Alexey Voronin.
 * @since 27.03.2018.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @RequestMapping("/current")
    @ResponseBody
    public Map<String, String> getCurrentUser(final Principal principal) {
        if (principal != null) {
            User user = userService.getByEmail(principal.getName());
            Map<String, String> map = new HashMap<>();
            map.put("name", user.getFirstName());
            map.put("role", user.getRoles().iterator().next().getRole().equalsIgnoreCase(
                    "admin") ? "admin" : "user");
            return map;
        }
        return null;
    }

    @RequestMapping("/user")
    public ModelAndView User(final Principal principal) {
        final ModelAndView view = new ModelAndView("user");
        view.addObject("user", this.userService.getByEmail(principal.getName()));
        return view;
    }

    @RequestMapping("/update-user")
    public ModelAndView updateUser(final User user) {
        this.userService.update(user);
        return new ModelAndView("redirect:/user");
    }

}
