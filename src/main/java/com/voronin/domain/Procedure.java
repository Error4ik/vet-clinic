package com.voronin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 07.03.2018.
 */
@Entity(name = "services")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private int price;

    private Timestamp date;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pet_service", joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Procedure)) {
            return false;
        }
        Procedure service = (Procedure) o;
        return getId() == service.getId()
                && getPrice() == service.getPrice()
                && Objects.equals(getName(), service.getName())
                && Objects.equals(getDescription(), service.getDescription())
                && Objects.equals(getDate(), service.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getDate());
    }

    @Override
    public String toString() {
        return String.format("Service: {id=%s name=%s price=%s date=%s}",
                this.getId(), this.getName(), this.getPrice(), this.getDate());
    }
}
