package com.cg.multiplexbookingsystem.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.cg.multiplexbookingsystem.entity.Movie;
import com.cg.multiplexbookingsystem.exceptions.MovieAlreadyExistException;
import com.cg.multiplexbookingsystem.exceptions.MovieNotFoundException;


public interface IMovieService {
	
	public List<Movie> getAllMovies();
	public ResponseEntity<Movie> showMovieDetails(Long movieId) throws MovieNotFoundException;
	public Movie addMovieDetails(Movie movie) throws MovieAlreadyExistException;	
	public ResponseEntity<Movie> updateMovieDetails(Long movieid, Movie movie) throws MovieNotFoundException;
	public Map<String,Boolean> deleteMovieDetails(Long movieId) throws MovieNotFoundException;
	

}
