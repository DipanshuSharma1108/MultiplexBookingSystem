package com.cg.multiplexbookingsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.cg.multiplexbookingsystem.service.IUserService;


@RestController
@RequestMapping("/AppV1")
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/adduserdetails")
	public User addUserDetails(@RequestBody User user) throws UserAlreadyExistException {
		return userService.addUserDetails(user);
	}
	
	@GetMapping("/getallusers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/showuserdetails/{userid}")
	public User showUserDetails(@PathVariable("userid") Long userid) throws UserNotFoundException {
		return userService.showUserDetails(userid);
	}
	
	
	
	@PutMapping("/updateuserdetails")
	public User updateUserDetails(@RequestBody User user) throws UserNotFoundException {
		return userService.updateUserDetails(user);
	}
		
		
		//--------------------------------------------------------------------------------------------------------//
	@PutMapping("/user/{user}")
	public User updateUserDetailsById(@PathVariable("userid") Long userid,@RequestBody User user) throws UserNotFoundException {
		return userService.updateUserDetails(user);
	}
			
		
		@GetMapping("/user/{username}")
		public User showUserDetailsByName(@PathVariable("username") String userid) throws UserNotFoundException {
			return userService.showUserDetailsByName(userid);
		}
		
		@GetMapping("showmoviebyname/movie/{name}")
		public Movie showMovieDetailsByName(@PathVariable("name") String name) throws UserNotFoundException, MovieNotFoundException {
			return userService.viewAllMovieByName(name);
		}
		
		@GetMapping("viewshowbymoviename/movie/{name}/show")
		public List<Show> findShowByMovieName(@PathVariable("name") String name) throws MovieNotFoundException {
			return userService.findShowByMovieName(name);
		}
		
	//----------------booking---------------------------//
		
		@PostMapping("userbookmovie/movie/{movieid}/show/{showid}/hall/{hallid}/seattype/{seattypeid}/booking")
		public Map<String,Boolean> bookMovie(@PathVariable("movieid") Long movieid,@PathVariable("showid") Long showid,
				@PathVariable("hallid") Long hallid, @PathVariable("seattypeid") Long seattypeid,@RequestBody Booking booking,@RequestParam(name="userid") Long userid,
				@RequestParam(name="count") int count) throws BookingAlreadyExistException, MovieNotFoundException, HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException, CapacityExceededException, LessSeatsAvailableException{
			
			return userService.bookMovie(movieid, showid, hallid, seattypeid, booking, userid, count);
		
			}
		@DeleteMapping("userdeletemovie/movie/{movieid}/show/{showid}/hall/{hallid}/seattype/{seattypeid}/booking/{bookingid}")
		public Map<String,Boolean> cancelBooking(@PathVariable("movieid") Long movieid,@PathVariable("showid") Long showid,
				@PathVariable("hallid") Long hallid, @PathVariable("seattypeid") Long seattypeid,@PathVariable("bookingid") Long bookingid, @RequestParam(name="userid") Long userid
				) throws BookingAlreadyExistException, MovieNotFoundException, HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException, CapacityExceededException, LessSeatsAvailableException, BookingDetailNotFoundException{
			
			return userService.cancelBooking(movieid, showid, hallid, seattypeid, bookingid, userid);
		
			}
		
	}

	


