package com.voronin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Index controller.
 *
 * @author Alexey Voronin.
 * @since 16.02.2018.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView getIndex() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }
}
