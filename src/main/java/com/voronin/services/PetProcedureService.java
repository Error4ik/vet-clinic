package com.voronin.services;

import com.voronin.domain.PetProcedure;
import com.voronin.repository.PetProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 08.04.2018.
 */
@Service
public class PetProcedureService {

    @Autowired
    private PetProcedureRepository petServiceRepository;

    public PetProcedure save(final PetProcedure petProcedure) {
        return this.petServiceRepository.save(petProcedure);
    }
}
