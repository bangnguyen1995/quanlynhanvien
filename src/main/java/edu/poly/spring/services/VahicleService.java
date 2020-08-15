package edu.poly.spring.services;

import java.util.Optional;

import edu.poly.spring.models.Vahicle;

public interface VahicleService {

	void deleteAll();

	void deleteAll(Iterable<? extends Vahicle> entities);

	void delete(Vahicle entity);

	void deleteById(Integer id);

	long count();

	Iterable<Vahicle> findAllById(Iterable<Integer> ids);

	Iterable<Vahicle> findAll();

	boolean existsById(Integer id);

	Optional<Vahicle> findById(Integer id);

	<S extends Vahicle> Iterable<S> saveAll(Iterable<S> entities);

	Vahicle save(Vahicle entity);


}
