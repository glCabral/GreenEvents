package com.example.greenevents.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.greenevents.model.Organizer;
import com.example.greenevents.repository.OrganizerRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {
    private final OrganizerRepository repository;

    public OrganizerController(OrganizerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Organizer create(@Valid @RequestBody Organizer organizer) {
        return repository.save(organizer);
    }

}
