package com.example.moodcheckerapi.repositories;
import com.example.moodcheckerapi.models.Mood;
import org.springframework.data.repository.CrudRepository;

public interface MoodsRepository extends CrudRepository<Mood, Long> {

}