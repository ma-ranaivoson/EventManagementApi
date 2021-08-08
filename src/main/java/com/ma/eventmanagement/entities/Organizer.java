package com.ma.eventmanagement.entities;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.OneToMany;

@Entity
public class Organizer extends AbstractEntity {
	private String name;
	@OneToMany(mappedBy = "organizer")
	private Set<Event> events;

	public Organizer() {
	}

	public Organizer(Long id, Instant created, String name, Set<Event> events) {
		super();
		this.id = id;
		this.created = created;
		this.name = name;
		this.events = events;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Organizer) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
