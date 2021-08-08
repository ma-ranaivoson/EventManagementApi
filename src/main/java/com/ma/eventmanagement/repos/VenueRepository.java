package com.ma.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ma.eventmanagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

}
