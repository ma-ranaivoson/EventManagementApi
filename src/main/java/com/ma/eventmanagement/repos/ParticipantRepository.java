package com.ma.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ma.eventmanagement.entities.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

}
