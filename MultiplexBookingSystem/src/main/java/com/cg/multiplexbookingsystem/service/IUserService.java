package com.cg.multiplexbookingsystem.service;

import java.util.List;
import java.util.Map;

import com.cg.multiplexbookingsystem.entity.Booking;
import com.cg.multiplexbookingsystem.entity.Movie;
import com.cg.multiplexbookingsystem.entity.Show;
import com.cg.multiplexbookingsystem.entity.User;
import com.cg.multiplexbookingsystem.exceptions.BookingAlreadyExistException;
import com.cg.multiplexbookingsystem.exceptions.BookingDetailNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.CapacityExceededException;
import com.cg.multiplexbookingsystem.exceptions.HallNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.LessSeatsAvailableException;
import com.cg.multiplexbookingsystem.exceptions.MovieNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.SeatTypeNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.ShowNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.UserAlreadyExistException;
import com.cg.multiplexbookingsystem.exceptions.UserNotFoundException;

public interface IUserService {
	
	
	
	
	public User updateUserDetailsById(Long userid,User user) throws UserNotFoundException;
	
	public User addUserDetails(User user) throws UserAlreadyExistException;
	
	public User updateUserDetails(User user) throws UserNotFoundException;
	
	public User showUserDetails(Long userid) throws UserNotFoundException;
	
	public User showUserDetailsByName(String username) throws UserNotFoundException;
	
	public List<User> getAllUsers();
	
	public Movie viewAllMovieByName(String moviename) throws MovieNotFoundException;

	public List<Show>findShowByMovieName(String name) throws MovieNotFoundException;
	
	public Map<String,Boolean> bookMovie(Long movieid,Long showid,Long hallid,Long seattypeid, Booking booking, long userid, int count) throws BookingAlreadyExistException, MovieNotFoundException, HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException, CapacityExceededException, LessSeatsAvailableException;
	
	public Map<String,Boolean> cancelBooking(Long movieid,Long showid,Long hallid,Long seattypeid, Long bookingid, long userid) throws BookingAlreadyExistException, MovieNotFoundException, HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException, CapacityExceededException, LessSeatsAvailableException, BookingDetailNotFoundException;

}
