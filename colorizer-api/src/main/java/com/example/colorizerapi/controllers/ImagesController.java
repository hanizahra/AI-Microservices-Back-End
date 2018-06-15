package com.example.colorizerapi.controllers;
import com.example.colorizerapi.models.Image;
import com.example.colorizerapi.repositories.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class ImagesController {

    @Autowired
    private ImagesRepository imagesRepository;

    @GetMapping("/images")
    public Iterable<Image> findAllImages() {
        return imagesRepository.findAll();
    }

    @GetMapping("/images/{imageId}")
    public Image findImageById(@PathVariable Long imageId) {
        return imagesRepository.findOne(imageId);
    }

    @DeleteMapping("/images/{imageId}")
    public HttpStatus deleteImageById(@PathVariable Long imageId) {
        imagesRepository.delete(imageId);
        return HttpStatus.OK;
    }

    @PostMapping("/images")
    public Image createNewImage(@RequestBody Image newImage) {
        return imagesRepository.save(newImage);
    }

    @PatchMapping("/images/{imageId}")
    public Image updateImageById(@PathVariable Long imageId, @RequestBody Image imageRequest) {

        Image imageFromDb = imagesRepository.findOne(imageId);

        imageFromDb.setOriginalImage(imageRequest.getOriginalImage());
        imageFromDb.setColorizedImage(imageRequest.getColorizedImage());
        imageFromDb.setNote(imageRequest.getNote());

        return imagesRepository.save(imageFromDb);
    }



}