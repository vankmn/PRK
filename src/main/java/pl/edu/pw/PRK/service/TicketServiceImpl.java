package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.PRK.dao.TicketDao;
import pl.edu.pw.PRK.entity.Ticket;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;

	@Autowired
	public TicketServiceImpl(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	@Override
	public List<Ticket> findAll() {
		return ticketDao.findAll();
	}

	@Override
	public List<Ticket> findAllSortedByNumberAsc() {
		return ticketDao.findAllByOrderByNameAsc();
	}

	@Override
	public Ticket findById(int theId) {
		Optional<Ticket> result = ticketDao.findById(theId);

		Ticket Ticket = null;
		
		if (result.isPresent()) {
			Ticket = result.get();

		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Ticket id - " + theId);
		}
		
		return Ticket;
	}

	@Override
	public void save(Ticket Ticket) {
		ticketDao.save(Ticket);
	}

	@Override
	public void deleteById(int theId) {
		ticketDao.deleteById(theId);
	}

}






