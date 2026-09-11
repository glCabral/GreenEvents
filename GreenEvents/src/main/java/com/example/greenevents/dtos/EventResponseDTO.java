package com.example.greenevents.dtos;

import java.time.LocalDateTime;

import com.example.greenevents.model.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseDTO {

    private Long id;
    private String name;
    private LocalDateTime date;
    private String description;
    private Long organizerId;
    private String organizerName;

    public EventResponseDTO(Event event) {
        this.id = (event.getId());
        this.name = (event.getName());
        this.date = (event.getDate());
        this.description = (event.getDescription());
        this.organizerId = (event.getOrganizer().getId());
        this.organizerName = (event.getOrganizer().getName());

    }
}
