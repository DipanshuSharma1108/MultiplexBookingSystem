package com.cg.multiplexbookingsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.multiplexbookingsystem.entity.SeatType;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType,Long> {
	
	List<SeatType>findByHallId(Long hallid);
	Optional<SeatType> findByIdAndHallId(Long seattypeid,Long hallid);

}
