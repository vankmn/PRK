package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;

public interface ScheduleOfMoviesDAO extends JpaRepository<ScheduleOfMovie,Integer>{

}
