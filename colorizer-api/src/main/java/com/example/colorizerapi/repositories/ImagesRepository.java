package com.example.colorizerapi.repositories;
import com.example.colorizerapi.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImagesRepository extends CrudRepository<Image, Long> {

}