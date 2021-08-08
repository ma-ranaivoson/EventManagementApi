package com.ma.eventmanagement.repos;

import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ma.eventmanagement.entities.Event;
import com.ma.eventmanagement.entities.projections.PartialEventProjection;

@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	Page<Event> findByNameContaining(@Param("name") String name, Pageable pageable);
	Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable);
}
	