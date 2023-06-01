package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pw.PRK.entity.Seat;

import java.util.List;

public interface SeatDao extends JpaRepository<Seat, Integer> {

	List<Seat> findAllByOrderByHallIdAsc();

	@Query("SELECT s FROM Seat s WHERE s.hallId = ?1")
	List<Seat> findSeatAssignedToHall(int hallId);

}
