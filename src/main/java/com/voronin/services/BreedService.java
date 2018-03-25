package com.voronin.services;

import com.voronin.domain.Breed;
import com.voronin.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 11.02.2018.
 */

@Service
public class BreedService {

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private PetTypeService petTypeService;

    public Breed save(final Breed breed) {
        return this.breedRepository.save(breed);
    }

    public Breed getById(final long id) {
        return this.breedRepository.findOne(id);
    }

    public List<Breed> getBreads() {
        return (List<Breed>) this.breedRepository.findAll();
    }

    public void removeBreadById(final long id) {
        this.breedRepository.delete(id);
    }

    public List<Breed> getBreedByTypeId(final int id) {
        return this.breedRepository.getBreedsByTypeId(id);
    }

    public Breed getBreedByName(final String name) {
        return this.breedRepository.getByName(name);
    }
}
