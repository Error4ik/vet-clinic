package com.voronin.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Pet procedure.
 *
 * @author Alexey Voronin.
 * @since 08.04.2018.
 */
@Entity(name = "pet_service")
public class PetProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pet_id")
    private int petId;

    @Column(name = "service_id")
    private int serviceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetProcedure)) return false;
        PetProcedure that = (PetProcedure) o;
        return getId() == that.getId() &&
                getPetId() == that.getPetId() &&
                getServiceId() == that.getServiceId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPetId(), getServiceId());
    }
}
