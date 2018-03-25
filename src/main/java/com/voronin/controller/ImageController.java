package com.voronin.controller;

import com.voronin.services.ImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Image controller.
 *
 * @author Alexey Voronin.
 * @since 04.03.2018.
 */
@Controller
public class ImageController {

    /**
     * Photo service.
     */
    @Autowired
    private ImageService photoService;

    /**
     * Mapping web requests /image/{photoID}.
     *
     * @param photoID id photo to be search in the database.
     * @return byte array.
     * @throws IOException if you can not get an array of bytes from the photo.
     */
    @ResponseBody
    @GetMapping(value = "/image/{photoID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable final int photoID) throws IOException {
        return IOUtils.toByteArray(new FileInputStream(new File(this.photoService.getById(photoID).getImageUrl())));
    }
}
