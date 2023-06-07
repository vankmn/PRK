package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.PRK.dao.MovieSeatsDAO;
import pl.edu.pw.PRK.dao.SeatDao;
import pl.edu.pw.PRK.entity.Hall;
import pl.edu.pw.PRK.entity.MovieSeats;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;
import pl.edu.pw.PRK.entity.Seat;

import java.util.List;
import java.util.Optional;

@Service
public class MovieSeatsServiceImp implements MovieSeatsService {

	private final MovieSeatsDAO movieSeatsDAO;
	private final SeatDao seatDao;

	@Autowired
	public MovieSeatsServiceImp(MovieSeatsDAO movieSeatsDAO, SeatDao seatDao) {
		this.movieSeatsDAO = movieSeatsDAO;
		this.seatDao=seatDao;
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

	@Override
	public void createBunchOfSeatsForNewMovie(ScheduleOfMovie scheduleOfMovie, Hall hall) {

		deleteBunchOfSeatsForNewMovie(scheduleOfMovie);

		List<Seat> seatList = seatDao.findSeatAssignedToHall(hall);
		for (Seat seat : seatList) {
			MovieSeats movieSeats = new MovieSeats(scheduleOfMovie, seat);
			movieSeatsDAO.save(movieSeats);
		}
	}

	@Override
	public void deleteBunchOfSeatsForNewMovie(ScheduleOfMovie scheduleOfMovie) {
		List<MovieSeats> movieSeatsList = movieSeatsDAO.findSeatAssignedToScheduledMovie(scheduleOfMovie);
		for (MovieSeats movieSeats : movieSeatsList) {
			movieSeatsDAO.deleteById(movieSeats.getId());
		}
	}

	@Override
	public List<MovieSeats> findNotOccupiedSeats(ScheduleOfMovie scheduleOfMovie) {
		return movieSeatsDAO.findNotOccupiedSeats(scheduleOfMovie);
	}


}






