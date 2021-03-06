package edu.poly.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Records;
@Repository
public interface RecordRepository extends CrudRepository<Records, Integer> {
List<Records> findByStaffId(Integer staffID);
}
