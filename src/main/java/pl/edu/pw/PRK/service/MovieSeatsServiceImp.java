package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.PRK.dao.MovieSeatsDAO;
import pl.edu.pw.PRK.dao.ScheduleOfMoviesDAO;
import pl.edu.pw.PRK.entity.MovieSeats;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;

import java.util.List;
import java.util.Optional;

@Service
public class MovieSeatsServiceImp implements MovieSeatsService {

	private final MovieSeatsDAO movieSeatsDAO;

	@Autowired
	public MovieSeatsServiceImp(MovieSeatsDAO movieSeatsDAO) {
		this.movieSeatsDAO = movieSeatsDAO;
	}

	@Override
	public List<MovieSeats> findAll() {
		return movieSeatsDAO.findAll();
	}

	@Override
	public MovieSeats findById(int theId) {
		Optional<MovieSeats> result = movieSeatsDAO.findById(theId);

		MovieSeats movieSeats = null;

		if (result.isPresent()) {
			movieSeats = result.get();

		}
		else {
			// we didn't find
			throw new RuntimeException("Did not find movie seat id - " + theId);
		}

		return movieSeats;
	}

	@Override
	public void save(MovieSeats movieSeats) {
		movieSeatsDAO.save(movieSeats);
	}

	@Override
	public void deleteById(int theId) {
		movieSeatsDAO.deleteById(theId);
	}

}






