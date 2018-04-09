package com.voronin.services;

import com.voronin.domain.Procedure;
import com.voronin.repository.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 08.03.2018.
 */
@Service
public class ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    public Procedure save(final Procedure procedure) {
        return procedureRepository.save(procedure);
    }

    public Procedure getById(final int id) {
        return this.procedureRepository.findOne(id);
    }

    public List<Procedure> findAll() {
        return this.procedureRepository.findAll();
    }

    public void deleteById(final int id) {
        this.procedureRepository.delete(id);
    }

    public Procedure prepareProcedureToSave(final Procedure procedure) {
        procedure.setDate(new Timestamp(System.currentTimeMillis()));
        return procedure;
    }

    public Procedure getProcedureByName(final String name) {
        return this.procedureRepository.findByName(name);
    }
}
