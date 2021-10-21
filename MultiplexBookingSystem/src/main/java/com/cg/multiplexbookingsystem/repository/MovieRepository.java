package com.cg.multiplexbookingsystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.multiplexbookingsystem.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
	
	public Movie findBymovieName(String moviename);

}
