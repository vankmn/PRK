package pl.edu.pw.PRK.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.PRK.entity.Hall;
import pl.edu.pw.PRK.entity.SoldTicket;

import java.util.List;

public interface SoldTicketsDAO extends JpaRepository<SoldTicket, Integer> {


	
}
