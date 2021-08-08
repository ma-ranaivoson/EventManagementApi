package com.ma.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ma.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {
}
