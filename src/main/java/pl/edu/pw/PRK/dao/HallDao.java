package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.PRK.entity.Hall;
import pl.edu.pw.PRK.entity.Movie;

import java.util.List;

public interface HallDao extends JpaRepository<Hall, Integer> {

	List<Hall> findAllByOrderByNumberAsc();
	
}
