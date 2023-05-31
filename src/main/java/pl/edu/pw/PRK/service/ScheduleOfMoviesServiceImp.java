package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.PRK.dao.ScheduleOfMoviesDAO;
import pl.edu.pw.PRK.entity.ScheduleOfMovies;

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
	public List<ScheduleOfMovies> findAll() {
		return scheduleOfMoviesDAO.findAll();
	}

	@Override
	public ScheduleOfMovies findById(int theId) {
		Optional<ScheduleOfMovies> result = scheduleOfMoviesDAO.findById(theId);

		ScheduleOfMovies scheduleOfMovies = null;

		if (result.isPresent()) {
			scheduleOfMovies = result.get();

		}
		else {
			// we didn't find the
			throw new RuntimeException("Did not find movie id - " + theId);
		}

		return scheduleOfMovies;
	}

	@Override
	public void save(ScheduleOfMovies scheduleOfMovies) {
		scheduleOfMoviesDAO.save(scheduleOfMovies);
	}

	@Override
	public void deleteById(int theId) {
		scheduleOfMoviesDAO.deleteById(theId);
	}

}






