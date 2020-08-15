package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.poly.spring.models.departs;
import edu.poly.spring.repositories.DepartRepository;

public interface DepartService {

	void deleteAll();

	void deleteAll(List<departs> entities);

	void delete(departs entity);

	void deleteById(Integer id);

	long count();

	List<departs> findAllById(List<Integer> id);

	Iterable<departs> findAll();

	boolean existsById(Integer id);

	Optional<departs> findById(Integer id);

	List<departs> saveAll(List<departs>  entities);

	departs save(departs entity);



}
