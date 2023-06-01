package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.MovieSeats;

import java.util.List;

public interface MovieSeatsService {

	List<MovieSeats> findAll();

	MovieSeats findById(int theId);

	void save(MovieSeats scheduleOfMovie);

	void deleteById(int theId);


}
