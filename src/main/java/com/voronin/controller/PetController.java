package com.voronin.controller;

import com.voronin.domain.Breed;
import com.voronin.domain.FillPetCreated;
import com.voronin.domain.PetType;
import com.voronin.services.BreedService;
import com.voronin.services.PetService;
import com.voronin.services.PetTypeService;
import com.voronin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 28.02.2018.
 */
@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetTypeService petTypeService;

    @Autowired
    private UserService userService;

    @Autowired
    private BreedService breedService;

    @RequestMapping("/all")
    public ModelAndView petPage() {
        final ModelAndView view = new ModelAndView("pet-info");
        view.addObject("pets", userService.getOwners());
        return view;
    }

    @RequestMapping("/add-pet")
    public ModelAndView addNewPet() {
        final ModelAndView view = new ModelAndView("add-pet");
        return view;
    }

    @RequestMapping("/pet-type")
    @ResponseBody
    public List<PetType> getPetTypes() {
        return this.petTypeService.getTypes();
    }

    @RequestMapping("/breed-by-type")
    @ResponseBody
    public List<Breed> getBreedByType(@RequestParam final String type) {
        return this.breedService.getBreedByTypeId(this.petTypeService.getTypeByName(type).getId());
    }

    @RequestMapping(value = "/create-pet", method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public ModelAndView createPet(FillPetCreated model, @RequestParam(value = "upFile", required = false)MultipartFile file) {
        this.petService.save(this.petService.preparePet(model, file));
        return new ModelAndView("redirect:/user");
    }

    @RequestMapping("/pet-info/{id}")
    public ModelAndView petInfo(@PathVariable final String id) {
        final ModelAndView view = new ModelAndView("pet-info");
        view.addObject("pet", this.petService.getById(Integer.parseInt(id)) );
        return view;
    }
}
