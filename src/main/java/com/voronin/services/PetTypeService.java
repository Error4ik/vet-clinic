package com.voronin.services;

import com.voronin.domain.PetType;
import com.voronin.repository.PetTypeRepository;
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
public class PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    public PetType save(final PetType type) {
        return this.petTypeRepository.save(type);
    }

    public PetType getById(final long id) {
        return this.petTypeRepository.findOne(id);
    }

    public List<PetType> getTypes() {
        return (List<PetType>) this.petTypeRepository.findAll();
    }

    public void removeById(final long id) {
        this.petTypeRepository.delete(id);
    }

    public PetType getTypeByName(final String type) {
        return this.petTypeRepository.getByType(type);
    }
}
