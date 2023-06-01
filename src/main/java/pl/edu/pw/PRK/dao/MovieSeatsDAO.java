package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.PRK.entity.MovieSeats;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;

public interface MovieSeatsDAO extends JpaRepository<MovieSeats,Integer>{

}
