package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.Staffs;
import edu.poly.spring.models.departs;

public interface StaffService {

	

	List<departs> findAllDepart();

	void deleteAll();

	void deleteAll(List<Staffs> entities);

	void delete(Staffs entity);

	void deleteById(Integer id);

	long count();

	List<Staffs> findAllById(List<Integer> ids);

	Iterable<Staffs> findAll();

	boolean existsById(Integer id);

	Optional<Staffs> findById(Integer id);

	List<Staffs> saveAll(List<Staffs> entities);

	Staffs save(Staffs entity);

	List<Staffs> findByHotenLikeOrderByHoten(String name);





	

}
