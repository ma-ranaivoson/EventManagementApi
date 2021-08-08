package com.ma.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ma.eventmanagement.entities.Event;
import com.ma.eventmanagement.repos.EventRepository;

@RestController
@RequestMapping(value = "/eventmanagement/api/events")
public class EventKickOffController {	
	@Autowired
	private EventRepository eventRepository;

	@PostMapping(value = "/start/{id}")
	public @ResponseBody ResponseEntity<?> start(@PathVariable Long id) {
		Event event = eventRepository.findById(id).get();
		
		event.setStarted(true);
		eventRepository.save(event);

		return new ResponseEntity<>(event.getName() + " has started", HttpStatus.OK);
	}
}
