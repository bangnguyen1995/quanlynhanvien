package edu.poly.spring.repositories;



import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Staffs;

@Repository
public interface StaffRepository extends JpaRepository<Staffs, Integer> {
  List<Staffs> findByHotenLikeOrderByHoten(String name);
  
}
