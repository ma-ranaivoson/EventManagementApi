package com.ma.eventmanagement.entities.projections;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.ma.eventmanagement.entities.Event;

@Projection(name="partial", types={Event.class})
public interface PartialEventProjection {
	// Link: Get /eventmanagement/api/events?projection=partial
	String getName();
	ZonedDateTime getStartTime();
	ZonedDateTime getEndTime();
	Instant getCreated();
}
