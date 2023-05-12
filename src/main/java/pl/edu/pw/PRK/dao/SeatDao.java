package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.PRK.entity.Seat;

import java.util.List;

public interface SeatDao extends JpaRepository<Seat, Integer> {

	List<Seat> findAllByOrderByHallIdAsc();



}
