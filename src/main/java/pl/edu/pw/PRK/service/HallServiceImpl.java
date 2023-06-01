package pl.edu.pw.PRK.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.PRK.dao.HallDAO;
import pl.edu.pw.PRK.entity.Hall;

import java.util.List;
import java.util.Optional;

@Service
public class HallServiceImpl implements HallService {

	private final HallDAO hallDao;

	@Autowired
	public HallServiceImpl(HallDAO hallDao) {
		this.hallDao = hallDao;
	}
	
	@Override
	public List<Hall> findAll() {
		return hallDao.findAll();
	}

	@Override
	public List<Hall> findAllSortedByNumberAsc() {
		return hallDao.findAllByOrderByNumberAsc();
	}

	@Override
	public Hall findById(int theId) {
		Optional<Hall> result = hallDao.findById(theId);

		Hall hall = null;
		
		if (result.isPresent()) {
			hall = result.get();

		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find hall id - " + theId);
		}
		
		return hall;
	}

	@Override
	public void save(Hall hall) {
		hallDao.save(hall);
	}

	@Override
	public void deleteById(int theId) {
		hallDao.deleteById(theId);
	}

}






