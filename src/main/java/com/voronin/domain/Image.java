package com.voronin.domain;

import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Column;
import java.util.Objects;

/**
 * Pet Image.
 *
 * @author Alexey Voronin.
 * @since 08.02.2018.
 */
@Entity(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "image_url")
    private String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Image)) {
            return false;
        }
        Image image = (Image) o;
        return getId() == image.getId()
                && Objects.equals(getName(), image.getName())
                && Objects.equals(getImageUrl(), image.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getImageUrl());
    }

    @Override
    public String toString() {
        return String.format("Image: {id=%s name=%s url=%s}", this.getId(), this.getName(), this.getImageUrl());
    }
}
