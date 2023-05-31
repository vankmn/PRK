package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.PRK.entity.ScheduleOfMovies;

import java.util.List;

public interface ScheduleOfMoviesDAO extends JpaRepository<ScheduleOfMovies,Integer>{

}
