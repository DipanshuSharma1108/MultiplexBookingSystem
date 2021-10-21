package com.cg.multiplexbookingsystem.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.multiplexbookingsystem.entity.Booking;
import com.cg.multiplexbookingsystem.exceptions.BookingAlreadyExistException;
import com.cg.multiplexbookingsystem.exceptions.BookingDetailNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.CapacityExceededException;
import com.cg.multiplexbookingsystem.exceptions.HallNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.LessSeatsAvailableException;
import com.cg.multiplexbookingsystem.exceptions.MovieNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.SeatTypeNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.ShowNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.UserNotFoundException;
import com.cg.multiplexbookingsystem.service.BookingService;

@RestController
@RequestMapping("/AppV1")
public class BookingController {

	public BookingController() {
	}
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/movie/{movieid}/show/{showid}/hall/{hallid}/seattype/{seattypeid}/booking")
	public Map<String,Boolean> addBookingDetails(@PathVariable("movieid") Long movieid,@PathVariable("showid") Long showid,
			@PathVariable("hallid") Long hallid, @PathVariable("seattypeid") Long seattypeid,@RequestBody Booking booking,@RequestParam(name="userid") Long userid,
			@RequestParam(name="count") int count) throws BookingAlreadyExistException, MovieNotFoundException, HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException, CapacityExceededException, LessSeatsAvailableException{
		
		return bookingService.addBookingDetails(movieid, showid, hallid, seattypeid, booking, userid, count);
	
		}
	
	
	@DeleteMapping("/movie/{movieid}/show/{showid}/hall/{hallid}/seattype/{seattypeid}/booking/{bookingid}")
	public Map<String,Boolean> BookingDetails(@PathVariable("movieid") Long movieid,@PathVariable("showid") Long showid,
			@PathVariable("hallid") Long hallid, @PathVariable("seattypeid") Long seattypeid,@PathVariable("bookingid") Long bookingid, @RequestParam(name="userid") Long userid
			) throws BookingAlreadyExistException, MovieNotFoundException, HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException, CapacityExceededException, LessSeatsAvailableException, BookingDetailNotFoundException{
		
		return bookingService.deleteBookingDetails(movieid, showid, hallid, seattypeid, bookingid, userid);
	
		}
	
}
	


