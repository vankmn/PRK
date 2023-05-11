package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.Ticket;

import java.util.List;

public interface TicketService {

	List<Ticket> findAll();

	List<Ticket> findAllSortedByNumberAsc();

	Ticket findById(int theId);
	
	void save(Ticket ticket);
	
	void deleteById(int theId);
	
}
