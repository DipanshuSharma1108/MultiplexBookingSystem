package com.cg.multiplexbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.multiplexbookingsystem.entity.Show;
import com.cg.multiplexbookingsystem.exceptions.MovieNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.ShowAlreadyExistException;
import com.cg.multiplexbookingsystem.exceptions.ShowNotFoundException;

public interface IShowService {
	
	public ResponseEntity<Show> viewShowDetails(Long showid) throws ShowNotFoundException;
	
	public ResponseEntity<?> deleteShowDetails(Long movieid, Long showid) throws ShowNotFoundException,MovieNotFoundException;	
	
	public Show updateShowDetails(Long movieid, Long showid,Show show) throws ShowNotFoundException,MovieNotFoundException;
	
	public Show addShowDetails(Long movieid, Show show) throws ShowAlreadyExistException,MovieNotFoundException;
	
	List<Show> findByMovieId(Long movieid) throws MovieNotFoundException;
	
	Optional<Show> findByMovieIdAndShowId(Long movieId,Long showId);
	
	public List<Show> getAllShows();
	
	List<Show>findSlotByslotNo(long slotNo) throws ShowNotFoundException;
	
	List<Show>findShowByMovieName(String movieName) throws MovieNotFoundException;
	
	public List<Show> findByToDateContaining(String date) throws ShowNotFoundException;


}
