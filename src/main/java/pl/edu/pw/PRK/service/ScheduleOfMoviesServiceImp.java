package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.PRK.dao.ScheduleOfMoviesDAO;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleOfMoviesServiceImp implements ScheduleOfMoviesService {

	private final ScheduleOfMoviesDAO scheduleOfMoviesDAO;

	@Autowired
	public ScheduleOfMoviesServiceImp(ScheduleOfMoviesDAO scheduleOfMoviesDAO) {
		this.scheduleOfMoviesDAO = scheduleOfMoviesDAO;
	}

	@Override
	public List<ScheduleOfMovie> findAll() {
		return scheduleOfMoviesDAO.findAll();
	}

	@Override
	public ScheduleOfMovie findById(int theId) {
		Optional<ScheduleOfMovie> result = scheduleOfMoviesDAO.findById(theId);

		ScheduleOfMovie scheduleOfMovie = null;

		if (result.isPresent()) {
			scheduleOfMovie = result.get();

		}
		else {
			// we didn't find the
			throw new RuntimeException("Did not find movie id - " + theId);
		}

		return scheduleOfMovie;
	}

	@Override
	public void save(ScheduleOfMovie scheduleOfMovie) {
		scheduleOfMoviesDAO.save(scheduleOfMovie);
	}

	@Override
	public void deleteById(int theId) {
		scheduleOfMoviesDAO.deleteById(theId);
	}

}






