package com.voronin.services;

import com.voronin.domain.FillPetCreated;
import com.voronin.domain.Pet;
import com.voronin.repository.PetRepository;
import com.voronin.utils.WritePhotoToDisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 11.02.2018.
 */
@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private PetTypeService petTypeService;

    @Autowired
    private BreedService breedService;

    @Autowired
    private WritePhotoToDisk writePhotoToDisk;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    public Pet save(final Pet pet) {
        return this.petRepository.save(pet);
    }

    public Pet getById(final int id) {
        return this.petRepository.findOne(id);
    }

    public List<Pet> getPets() {
        return (List<Pet>) this.petRepository.findAll();
    }

    public void removePetById(final int id) {
        this.petRepository.delete(id);
    }

    public Pet preparePet(final FillPetCreated model, final MultipartFile file) {
        final Pet pet = new Pet();
        pet.setName(model.getName());
        pet.setAge(model.getAge());
        pet.setWeight(model.getWeight());
        pet.setImage(this.imageService.save(this.writePhotoToDisk.writePhotoToDisk(file)));
        pet.setPetType(this.petTypeService.getTypeByName(model.getPetType()));
        pet.setBreed(this.breedService.getBreedByName(model.getBreed()));
        pet.setOwner(this.userService.getByEmail(this.securityService.findLoggedUser()));
        return pet;
    }
}
