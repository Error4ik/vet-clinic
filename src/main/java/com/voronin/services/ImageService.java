package com.voronin.services;

import com.voronin.domain.Image;
import com.voronin.repository.ImageRepository;
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
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image save(final Image image) {
        return this.imageRepository.save(image);
    }

    public Image getById(final int id) {
        return this.imageRepository.findOne(id);
    }

    public List<Image> getImages() {
        return (List<Image>) this.imageRepository.findAll();
    }

    public void removeImageById(final int id) {
        this.imageRepository.delete(id);
    }
}
