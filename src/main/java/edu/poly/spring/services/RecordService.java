package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.Records;

public interface RecordService {

	List<Records> findByStaffId(Integer staffID);

	void deleteAll();

	void deleteAll(List<Records> entities);

	void delete(Records entity);

	void deleteById(Integer id);

	long count();

	Iterable<Records> findAllById(Iterable<Integer> ids);

	Iterable<Records> findAll();

	boolean existsById(Integer id);

	Optional<Records> findById(Integer id);

	List<Records> saveAll(List<Records> entities);

	Records save(Records entity);

}
