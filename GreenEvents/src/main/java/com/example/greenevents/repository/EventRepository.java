package com.example.greenevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.greenevents.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
