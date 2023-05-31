package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.ScheduleOfMovies;

import java.util.List;

public interface ScheduleOfMoviesService {

	List<ScheduleOfMovies> findAll();

	ScheduleOfMovies findById(int theId);

	void save(ScheduleOfMovies scheduleOfMovies);

	void deleteById(int theId);


}
