package com.voronin.controller;

import com.voronin.domain.Procedure;
import com.voronin.services.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 07.03.2018.
 */
@Controller
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @RequestMapping("/procedures")
    public ModelAndView getView() {
        final ModelAndView view = new ModelAndView("procedures");
        view.addObject("procedures", this.procedureService.findAll());
        return view;
    }

    @RequestMapping("/add-procedure")
    public ModelAndView getProcedurePage() {
        final ModelAndView view = new ModelAndView("add-procedure");
        return view;
    }

    @RequestMapping(value = "/create-procedure", method = RequestMethod.POST)
    public String saveProcedure(final Procedure procedure) {
        this.procedureService.save(this.procedureService.prepareProcedureToSave(procedure));
        return "redirect:/procedures";
    }
}
