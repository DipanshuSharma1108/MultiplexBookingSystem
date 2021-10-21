package com.cg.multiplexbookingsystem.service;

import java.util.Map;

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

public interface IBookingService {

	public Map<String,Boolean> addBookingDetails(Long movieid,Long showid,Long hallid,Long seattypeid, Booking booking, long userid, int count) throws BookingAlreadyExistException, MovieNotFoundException, HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException, CapacityExceededException, LessSeatsAvailableException;
	
	public Map<String,Boolean> deleteBookingDetails(Long movieid,Long showid,Long hallid,Long seattypeid, Long bookingid, long userid) throws BookingAlreadyExistException, MovieNotFoundException, HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException, CapacityExceededException, LessSeatsAvailableException, BookingDetailNotFoundException;

}
