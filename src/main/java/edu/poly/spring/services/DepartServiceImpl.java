package edu.poly.spring.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.departs;
import edu.poly.spring.repositories.DepartRepository;

@Service
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartRepository departRepository;
	@Override
	public departs  save(departs entity) {
		return departRepository.save(entity);
	}

	@Override
	public List<departs>  saveAll(List<departs>  entities) {
		return (List<departs>) departRepository.saveAll(entities);
	}

	@Override
	public Optional<departs> findById(Integer id) {
		return departRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return departRepository.existsById(id);
	}

	@Override
	public Iterable<departs> findAll() {
		return departRepository.findAll();
	}

	@Override
	public List<departs> findAllById(List<Integer> ids) {
		return (List<departs>) departRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return departRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		departRepository.deleteById(id);
	}

	@Override
	public void delete(departs entity) {
		departRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<departs> entities) {
		departRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		departRepository.deleteAll();
	}

}
