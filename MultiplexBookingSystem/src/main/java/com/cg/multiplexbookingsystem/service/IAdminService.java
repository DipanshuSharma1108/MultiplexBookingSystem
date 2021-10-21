package com.cg.multiplexbookingsystem.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.multiplexbookingsystem.entity.Hall;
import com.cg.multiplexbookingsystem.entity.Movie;
import com.cg.multiplexbookingsystem.entity.SeatType;
import com.cg.multiplexbookingsystem.entity.Show;
import com.cg.multiplexbookingsystem.entity.User;
import com.cg.multiplexbookingsystem.exceptions.HallNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.MovieAlreadyExistException;
import com.cg.multiplexbookingsystem.exceptions.MovieNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.SeatTypeAlreadyExistException;
import com.cg.multiplexbookingsystem.exceptions.SeatTypeNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.ShowAlreadyExistException;
import com.cg.multiplexbookingsystem.exceptions.ShowNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.UserNotFoundException;

public interface IAdminService {
	
//-------------------user-------------------------//
	public User updateUserDetailsById(Long userid,User user) throws UserNotFoundException;
	
	public User showUserDetails(Long userid) throws UserNotFoundException;
	
	public User showUserDetailsByName(String username) throws UserNotFoundException;
	
	public List<User> getAllUsers();
	
	public Movie viewAllMovieByName(String moviename) throws MovieNotFoundException;
	
	public List<Show>findShowByMovieName(String name) throws MovieNotFoundException;
	
	//----------------movie--------------------//
	
	public List<Movie> getAllMovies();
	
	public ResponseEntity<Movie> showMovieDetails(Long movieId) throws MovieNotFoundException;
	
	public Movie addMovieDetails(Movie movie) throws MovieAlreadyExistException;
	
	public ResponseEntity<Movie> updateMovieDetails(Long movieid, Movie movie) throws MovieNotFoundException;
	
	public Map<String,Boolean> deleteMovieDetails(Long movieId) throws MovieNotFoundException;
	
	
	//------------------show-----------------//
	public ResponseEntity<Show> viewShowDetails(Long showid) throws ShowNotFoundException;
	
	public ResponseEntity<?> deleteShowDetails(Long movieid, Long showid) throws ShowNotFoundException,MovieNotFoundException;	
	
	public Show updateShowDetails(Long movieid, Long showid,Show show) throws ShowNotFoundException,MovieNotFoundException;
	
	public Show addShowDetails(Long movieid, Show show) throws ShowAlreadyExistException,MovieNotFoundException;
	
	List<Show> findByMovieId(Long movieid) throws MovieNotFoundException;
	
	public List<Show> getAllShows();
	
	public Object addMovieDetailsCascaded(Movie movie,Long movieid, Show show) throws MovieNotFoundException;
	
	//-----------------hall------------------------------//
	
	public List<Hall> getAllHalls();
	
	public ResponseEntity<Hall> viewHallDetails(Long hallid) throws HallNotFoundException;
	
	public ResponseEntity<?> deleteHallDetailsById(Long showid, Long hallid) throws ShowNotFoundException,MovieNotFoundException,HallNotFoundException;	
	
	public Hall updateHallDetailsById(Long movieid, Long showid, Long Halllid, Hall hall) throws ShowNotFoundException,MovieNotFoundException,HallNotFoundException;
	
	public Hall addHallDetailsById(Long showid, Hall hall) throws ShowAlreadyExistException,MovieNotFoundException, ShowNotFoundException;
	
	public List<Hall>findHallByShowId(Long showId)throws HallNotFoundException,ShowNotFoundException;
	
	//-----------admin-----------------------------------//
	
	public List<SeatType> getAllSeatTypes();	
	
	public ResponseEntity<SeatType> viewSeatTypeDetails(Long seattypeid) throws SeatTypeNotFoundException;
	
	public ResponseEntity<?> deleteSeatTypeDetails(Long hallid, Long seattypeid) throws HallNotFoundException,SeatTypeNotFoundException;	
	
	public SeatType updateSeatTypeDetails(Long hallid, Long seattypeid,SeatType seattype) throws HallNotFoundException,SeatTypeNotFoundException;
	
	public SeatType addSeatTypeDetails(Long hallid, SeatType seattype) throws SeatTypeAlreadyExistException,HallNotFoundException;
	
	List<SeatType> findByHallId(Long hallid);
	
	Optional<SeatType> findByIdAndHallId(Long seattypeid,Long hallid);
}
