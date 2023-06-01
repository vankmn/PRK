package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.SoldTicket;

import java.util.List;

public interface SoldTicketsService {

	List<SoldTicket> findAll();

	SoldTicket findById(int theId);
	
	void save(SoldTicket soldTicket);
	
	void deleteById(int theId);


}
