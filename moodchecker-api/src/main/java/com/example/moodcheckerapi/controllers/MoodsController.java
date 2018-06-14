package com.example.moodcheckerapi.controllers;

import com.example.moodcheckerapi.models.Mood;
import com.example.moodcheckerapi.repositories.MoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;



@RestController
public class MoodsController {

    @Autowired
    private MoodsRepository moodsRepository;

    @GetMapping("/moods")
    public Iterable<Mood> findAllMoods() {
        return moodsRepository.findAll();
    }

    @GetMapping("/moods/{moodId}")
    public Mood findMoodById(@PathVariable Long moodId) {
        return moodsRepository.findOne(moodId);
    }

    @DeleteMapping("/moods/{moodId}")
    public HttpStatus deleteMoodById(@PathVariable Long moodId) {
        moodsRepository.delete(moodId);
        return HttpStatus.OK;
    }

    @PostMapping("/moods")
    public Mood createNewMood(@RequestBody Mood newMood) {
        return moodsRepository.save(newMood);
    }

    @PatchMapping("/moods/{moodId}")
    public Mood updateMoodById(@PathVariable Long moodId, @RequestBody Mood moodRequest) {

        Mood moodFromDb = moodsRepository.findOne(moodId);

        moodFromDb.setUserInput(moodRequest.getUserInput());
        moodFromDb.setApiOutput(moodRequest.getApiOutput());
        moodFromDb.setNote(moodRequest.getNote());

        return moodsRepository.save(moodFromDb);
    }

}