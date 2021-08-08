package com.ma.eventmanagement.controllers;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ma.eventmanagement.controllers.exceptions.AlreadyCheckedInException;
import com.ma.eventmanagement.entities.Participant;
import com.ma.eventmanagement.repos.ParticipantRepository;

@RestController
@RequestMapping(value = "/eventmanagement/api/events")
public class CheckInController {
	@Autowired
	private ParticipantRepository participantRepository;

	// Custom response
	HashMap<String, Object> res = new HashMap<String, Object>();

	@PostMapping(value = "/checkin/{id}")
	public @ResponseBody ResponseEntity<?> checkIn(@PathVariable Long id) throws JsonProcessingException {
		Participant participant = participantRepository.findById(id).get();

		if (participant.getCheckedIn())
			throw new AlreadyCheckedInException();

		participant.setCheckedIn(true);
		participantRepository.save(participant);

		res.put("name", participant.getName());
		res.put("email", participant.getEmail());
		res.put("event", participant.getEvent().getName());	
		res.put("checkedIn", participant.getCheckedIn());

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
