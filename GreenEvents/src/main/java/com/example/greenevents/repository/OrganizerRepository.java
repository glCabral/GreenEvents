package com.example.greenevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.greenevents.model.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
