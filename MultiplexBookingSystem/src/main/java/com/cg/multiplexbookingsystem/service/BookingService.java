package com.cg.multiplexbookingsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.multiplexbookingsystem.entity.Booking;
import com.cg.multiplexbookingsystem.entity.Movie;
import com.cg.multiplexbookingsystem.exceptions.BookingAlreadyExistException;
import com.cg.multiplexbookingsystem.exceptions.BookingDetailNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.BookingNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.CapacityExceededException;
import com.cg.multiplexbookingsystem.exceptions.HallNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.LessSeatsAvailableException;
import com.cg.multiplexbookingsystem.exceptions.MovieNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.SeatTypeNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.ShowNotFoundException;
import com.cg.multiplexbookingsystem.exceptions.UserNotFoundException;
import com.cg.multiplexbookingsystem.repository.BookingRepository;
import com.cg.multiplexbookingsystem.repository.HallRepository;
import com.cg.multiplexbookingsystem.repository.MovieRepository;
import com.cg.multiplexbookingsystem.repository.SeatTypeRepository;
import com.cg.multiplexbookingsystem.repository.ShowRepository;
import com.cg.multiplexbookingsystem.repository.UserRepository;


@Service
public class BookingService implements IBookingService{

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ShowRepository showRepository;
	@Autowired
	private HallRepository hallRepository;
	@Autowired 
	private SeatTypeRepository seattypeRepository; 
	@Autowired 
	private UserRepository userRepository;
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	HallService hallService;
	
	public BookingService() {
		
	}

	@Override
	public Map<String,Boolean> addBookingDetails(Long movieid,Long showid,Long hallid,Long seattypeid, Booking booking,long userid, int count) throws BookingAlreadyExistException, MovieNotFoundException, HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException, CapacityExceededException, LessSeatsAvailableException {
		Map<String,Boolean> response = new HashMap<>();
		{
		
		if(!userRepository.existsById(userid)) {
			throw new UserNotFoundException("Sorry the user with user id: "+userid+"is not found..!! Please register yourself or login");
		}
	
		else if(!movieRepository.existsById(movieid)) {
			throw new MovieNotFoundException("Sorry the movie with movie id: "+movieid+" is not found..!!");
		}
		else if(!showRepository.existsById(showid)) {
			throw new ShowNotFoundException("Sorry the show with show id: "+showid+" is not found..!!");
		}
		else if(!hallRepository.existsById(hallid)) {
			throw new HallNotFoundException("Sorry the hall with hall id: "+hallid+ " is not found..!!");
		}
		else if(!seattypeRepository.existsById(seattypeid)) {
			throw new SeatTypeNotFoundException("Sorry the seat type with seat type id: "+seattypeid+" is not found..!!");
		}
	}
	
		if(hallRepository.getById(hallid).getTotalcapacity()<count) {
			throw new CapacityExceededException("The number of seats requested is more than the hall's total capacity..!! Please select less seats");
		}
		else if(hallRepository.getById(hallid).getAvailableSeats()<count) {
			throw new LessSeatsAvailableException("Not enough seats are present at the moment!! Please select less seats or choose another slot");
		}
		
		else {
			
			
			hallService.subtractAvailableSeats(hallid, count);
			response.put("Booking done successfully", true);
			
			
		}
		//booking.setUser(userRepository.getById(userid));

		bookingRepository.save(booking);
		return response;
	}

	@Override
	public Map<String, Boolean> deleteBookingDetails(Long movieid, Long showid, Long hallid, Long seattypeid,
			Long bookingid, long userid) throws BookingAlreadyExistException, MovieNotFoundException,
			HallNotFoundException, SeatTypeNotFoundException, ShowNotFoundException, UserNotFoundException,
			CapacityExceededException, LessSeatsAvailableException, BookingDetailNotFoundException {
		
		Map<String,Boolean> response = new HashMap<>();
		{
		
		if(!userRepository.existsById(userid)) {
			throw new UserNotFoundException("Sorry the user with user id: "+userid+"is not found..!! Please register yourself or login");
		}
	
		else if(!movieRepository.existsById(movieid)) {
			throw new MovieNotFoundException("Sorry the movie with movie id: "+movieid+" is not found..!!");
		}
		else if(!showRepository.existsById(showid)) {
			throw new ShowNotFoundException("Sorry the show with show id: "+showid+" is not found..!!");
		}
		else if(!hallRepository.existsById(hallid)) {
			throw new HallNotFoundException("Sorry the hall with hall id: "+hallid+ " is not found..!!");
		}
		else if(!seattypeRepository.existsById(seattypeid)) {
			throw new SeatTypeNotFoundException("Sorry the seat type with seat type id: "+seattypeid+" is not found..!!");
		}
		else if(!seattypeRepository.existsById(bookingid)) {
			throw new BookingDetailNotFoundException("Sorry the booking with booking id: "+bookingid+" is not found..!!");

		}
	}
				
			hallService.addAvailableSeats(hallid, bookingRepository.getById(bookingid).getSeatcount());
			response.put("Booking deleted successfully", true);
			
			Booking booking = bookingRepository.findById(bookingid).orElseThrow(() ->new BookingDetailNotFoundException("Sorry the booking with booking id: "+bookingid+" is not found..!!"));

					
			
			bookingRepository.delete(booking);
			
		

		return response;
	}

}
