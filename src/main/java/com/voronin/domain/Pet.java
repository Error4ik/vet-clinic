package com.voronin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Pet.
 *
 * @author Alexey Voronin.
 * @since 08.02.2018.
 */
@Entity(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    private float weight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "breed_id")
    private Breed breed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "pet_service", joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Procedure> procedures;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet = (Pet) o;
        return getId() == pet.getId()
                && getAge() == pet.getAge()
                && Double.compare(pet.getWeight(), getWeight()) == 0
                && Objects.equals(getName(), pet.getName())
                && Objects.equals(getPetType(), pet.getPetType())
                && Objects.equals(getBreed(), pet.getBreed())
                && Objects.equals(getOwner(), pet.getOwner())
                && Objects.equals(getImage(), pet.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getWeight(), getPetType(), getBreed(), getOwner(), getImage());
    }

    @Override
    public String toString() {
        return String.format("Pet: {id=%s name=%s age=%s weight=%s type=%s breed=%s owner=%s image=%s}",
                this.getId(), this.getName(), this.getAge(), this.getWeight(), this.getPetType(), this.getBreed(),
                this.getOwner().getFirstName(), this.getImage());
    }
}
