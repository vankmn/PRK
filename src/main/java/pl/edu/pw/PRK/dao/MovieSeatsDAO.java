package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pw.PRK.entity.MovieSeats;
import pl.edu.pw.PRK.entity.ScheduleOfMovie;
import pl.edu.pw.PRK.entity.Seat;

import java.util.List;

public interface MovieSeatsDAO extends JpaRepository<MovieSeats,Integer>{

}
