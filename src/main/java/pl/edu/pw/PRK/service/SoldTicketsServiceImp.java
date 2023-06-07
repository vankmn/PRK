package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.PRK.dao.SoldTicketsDAO;
import pl.edu.pw.PRK.entity.SoldTicket;
import pl.edu.pw.PRK.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class SoldTicketsServiceImp implements SoldTicketsService {

	private final SoldTicketsDAO soldTicketsDAO;

	@Autowired
	public SoldTicketsServiceImp(SoldTicketsDAO soldTicketsDAO) {
		this.soldTicketsDAO = soldTicketsDAO;
	}
	
	@Override
	public List<SoldTicket> findAll() {
		return soldTicketsDAO.findAll();
	}

	@Override
	public SoldTicket findById(int theId) {
		Optional<SoldTicket> result = soldTicketsDAO.findById(theId);

		SoldTicket soldTicket = null;
		
		if (result.isPresent()) {
			soldTicket = result.get();

		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find sold ticket id - " + theId);
		}
		
		return soldTicket;
	}

	@Override
	public void save(SoldTicket soldTicket) {
		soldTicketsDAO.save(soldTicket);
	}

	@Override
	public void deleteById(int theId) {
		soldTicketsDAO.deleteById(theId);
	}

	@Override
	public List<SoldTicket> findTicketListForTheUser(User user) {
		return soldTicketsDAO.findTicketListForTheUser(user);
	}

}






