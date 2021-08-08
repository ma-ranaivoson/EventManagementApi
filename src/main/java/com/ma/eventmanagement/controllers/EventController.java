package com.ma.eventmanagement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class EventController {
	
	@GetMapping(value = "/create")
	public @ResponseBody ResponseEntity<?> createEvent(){	
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
}
