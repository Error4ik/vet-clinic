package com.voronin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Type of pet.
 *
 * @author Alexey Voronin.
 * @since 08.02.2018.
 */
@Entity(name = "pet_type")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PetType)) {
            return false;
        }
        PetType petType = (PetType) o;
        return getId() == petType.getId()
                && Objects.equals(getType(), petType.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType());
    }

    @Override
    public String toString() {
        return String.format("PetType: {id=%s type=%s}", this.getId(), this.getType());
    }
}
