package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.PRK.dao.SeatDao;
import pl.edu.pw.PRK.entity.Seat;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

	private final SeatDao seatDao;

	@Autowired
	public SeatServiceImpl(SeatDao seatDao) {
		this.seatDao = seatDao;
	}
	
	@Override
	public List<Seat> findAll() {
		return seatDao.findAll();
	}

	@Override
	public List<Seat> findAllSortedByHallIdAsc() {
		return seatDao.findAllByOrderByHallIdAsc();
	}

	@Override
	public Seat findById(int theId) {
		Optional<Seat> result = seatDao.findById(theId);

		Seat seat = null;
		
		if (result.isPresent()) {
			seat = result.get();

		}
		else {
			// we didn't find the seat
			throw new RuntimeException("Did not find seat id - " + theId);
		}
		
		return seat;
	}

	@Override
	public void save(Seat seat) {
		seatDao.save(seat);
	}

	@Override
	public void deleteById(int theId) {
		seatDao.deleteById(theId);
	}

}






