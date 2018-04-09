package com.voronin.controller;

import com.voronin.domain.PetProcedure;
import com.voronin.domain.Procedure;
import com.voronin.services.PetProcedureService;
import com.voronin.services.PetService;
import com.voronin.services.ProcedureService;
import com.voronin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 06.04.2018.
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProcedureService procedureService;

    @Autowired
    private PetService petService;

    @Autowired
    private PetProcedureService servicesPetsService;

    @RequestMapping("/admin-page")
    public ModelAndView getAdminPage() {
        final ModelAndView view = new ModelAndView("admin-page");
        view.addObject("users", this.userService.getUsers());
        view.addObject("procedures", this.procedureService.findAll());
        return view;
    }

    @RequestMapping(value = "/add-procedure-to-pet", method = RequestMethod.POST)
    public void addProcedureToPet(@RequestParam final int petId, @RequestParam final String name) {
        System.out.printf("Hello");
        Procedure procedure = this.procedureService.getProcedureByName(name);

        final PetProcedure petProcedure = new PetProcedure();
        petProcedure.setPetId(petId);
        petProcedure.setServiceId(procedure.getId());
        this.servicesPetsService.save(petProcedure);

//        return new ModelAndView("redirect:/admin-page");
    }
}
