package pl.edu.pw.PRK.service;

import pl.edu.pw.PRK.entity.SoldTicket;
import pl.edu.pw.PRK.entity.User;
import java.util.List;

public interface SoldTicketsService {

	List<SoldTicket> findAll();

	SoldTicket findById(int theId);
	
	void save(SoldTicket soldTicket);
	
	void deleteById(int theId);

	List <SoldTicket> findTicketListForTheUser(User user);
}
