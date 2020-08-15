package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Staffs;
import edu.poly.spring.models.departs;
import edu.poly.spring.repositories.DepartRepository;
import edu.poly.spring.repositories.StaffRepository;

@Service
public class StaffServiceImpl2 implements StaffService {
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private DepartRepository departRepository;

	@Override
	public List<departs> findAllDepart() {
		return (List<departs>) departRepository.findAll();
	}

	@Override
	public Staffs save(Staffs entity) {
		return staffRepository.save(entity);
	}

	@Override
	public List<Staffs> saveAll(List<Staffs> entities) {
		return (List<Staffs>) staffRepository.saveAll(entities);
	}

	@Override
	public Optional<Staffs> findById(Integer id) {
		return staffRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return staffRepository.existsById(id);
	}

	@Override
	public Iterable<Staffs> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public List<Staffs> findAllById(List<Integer> ids) {
		return (List<Staffs>) staffRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return staffRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		staffRepository.deleteById(id);
	}

	@Override
	public void delete(Staffs entity) {
		staffRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Staffs> entities) {
		staffRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffRepository.deleteAll();
	}

	@Override
	public List<Staffs> findByHotenLikeOrderByHoten(String name) {
		return staffRepository.findByHotenLikeOrderByHoten(name);
	}



	

}
