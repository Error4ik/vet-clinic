package com.voronin.controller;

import com.voronin.domain.Procedure;
import com.voronin.services.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @RequestMapping("/procedure")
    public ModelAndView getView() {
        final ModelAndView view = new ModelAndView("procedures");
        view.addObject("procedures", this.procedureService.findAll());
        return view;
    }

    @RequestMapping(value = "/create-procedure")
    public String saveProcedure(final Procedure procedure) {
        this.procedureService.save(this.procedureService.prepareProcedureToSave(procedure));
        return "redirect:/procedures";
    }

    @RequestMapping("/procedures")
    @ResponseBody
    public List<Procedure> getAll() {
        List<Procedure> procedures = this.procedureService.findAll();
        return procedures;
    }
}
