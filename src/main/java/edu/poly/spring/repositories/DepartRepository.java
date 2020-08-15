package edu.poly.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.departs;
@Repository
public interface DepartRepository extends CrudRepository<departs,Integer> {

}
