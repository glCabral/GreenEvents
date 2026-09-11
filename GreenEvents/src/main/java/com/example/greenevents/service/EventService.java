package com.example.greenevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.greenevents.dtos.EventRequestDTO;
import com.example.greenevents.dtos.EventResponseDTO;
import com.example.greenevents.exception.ResourceNotFoundException;
import com.example.greenevents.model.Event;
import com.example.greenevents.model.Organizer;
import com.example.greenevents.repository.EventRepository;
import com.example.greenevents.repository.OrganizerRepository;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final OrganizerRepository organizerRepository;

    public EventService(EventRepository eventRepository, OrganizerRepository organizerRepository) {
        this.eventRepository = eventRepository;
        this.organizerRepository = organizerRepository;
    }

    public EventResponseDTO createEvent(EventRequestDTO dto) {
        Organizer organizer = organizerRepository.findById(dto.getOrganizerId())
                .orElseThrow(() -> new ResourceNotFoundException("Organizador não encontrado"));

        Event event = new Event();
        event.setName(dto.getName());
        event.setDate(dto.getDate());
        event.setDescription(dto.getDescription());
        event.setOrganizer(organizer);

        Event saveEvent = eventRepository.save(event);

        return new EventResponseDTO(saveEvent);
    }

    public List<EventResponseDTO> findAll() {
        List<Event> events = eventRepository.findAll();

        return events.stream()
                .map(EventResponseDTO::new)
                .toList();
    }

    public EventResponseDTO findById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado"));
        return new EventResponseDTO(event);
    }

    @Autowired
    private EventRepository repository;

    public EventResponseDTO update(Long id, EventRequestDTO dto) {
        Event entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado. Id:" + id));
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EventResponseDTO(entity);

    }

    private void copyDtoToEntity(EventRequestDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
    }

    public void delete(Long id) {
        Event entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado. Id:" + id));

        repository.delete(entity);

    }
}
