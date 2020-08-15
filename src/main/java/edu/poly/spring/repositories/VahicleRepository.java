package edu.poly.spring.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Vahicle;


@Repository
public interface VahicleRepository extends CrudRepository<Vahicle, Integer> {

}
