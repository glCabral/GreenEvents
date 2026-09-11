package com.example.greenevents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.greenevents.dtos.EventRequestDTO;
import com.example.greenevents.dtos.EventResponseDTO;

import com.example.greenevents.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventResponseDTO> create(@RequestBody @Valid EventRequestDTO dto) {
        EventResponseDTO response = eventService.createEvent(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping()
    public ResponseEntity<List<EventResponseDTO>> findAll() {
        List<EventResponseDTO> list = eventService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> findById(@PathVariable Long id) {
        EventResponseDTO findById = eventService.findById(id);
        return ResponseEntity.ok(findById);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EventResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EventRequestDTO dto) {
        EventResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @Autowired
    private EventService service;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}