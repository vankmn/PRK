package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.PRK.dao.MovieDao;
import pl.edu.pw.PRK.entity.Movie;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieDao movieDao;
	
	@Autowired
	public MovieServiceImpl(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	@Override
	public List<Movie> findAll() {
		return movieDao.findAll();
	}

	@Override
	public List<Movie> findAllSortedByNameAsc() {
		return movieDao.findAllByOrderByNameAsc();
	}

	@Override
	public Movie findById(int theId) {
		Optional<Movie> result = movieDao.findById(theId);

		Movie theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();

		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Movie theEmployee) {
		movieDao.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		movieDao.deleteById(theId);
	}

}






