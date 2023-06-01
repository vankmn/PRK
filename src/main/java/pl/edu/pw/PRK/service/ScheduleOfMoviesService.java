package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.ScheduleOfMovie;

import java.util.List;

public interface ScheduleOfMoviesService {

	List<ScheduleOfMovie> findAll();

	ScheduleOfMovie findById(int theId);

	void save(ScheduleOfMovie scheduleOfMovie);

	void deleteById(int theId);


}
