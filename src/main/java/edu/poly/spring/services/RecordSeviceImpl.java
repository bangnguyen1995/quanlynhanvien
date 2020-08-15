package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Records;
import edu.poly.spring.repositories.RecordRepository;

@Service
public class RecordSeviceImpl implements RecordService {
@Autowired
RecordRepository recordRepository ;

@Override
public Records save(Records entity) {
	return recordRepository.save(entity);
}

@Override
public List<Records>  saveAll( List<Records> entities) {
	return (List<Records>) recordRepository.saveAll(entities);
}

@Override
public Optional<Records> findById(Integer id) {
	return recordRepository.findById(id);
}

@Override
public boolean existsById(Integer id) {
	return recordRepository.existsById(id);
}

@Override
public Iterable<Records> findAll() {
	return recordRepository.findAll();
}

@Override
public Iterable<Records> findAllById(Iterable<Integer> ids) {
	return recordRepository.findAllById(ids);
}

@Override
public long count() {
	return recordRepository.count();
}

@Override
public void deleteById(Integer id) {
	recordRepository.deleteById(id);
}

@Override
public void delete(Records entity) {
	recordRepository.delete(entity);
}

@Override
public void deleteAll(List<Records> entities) {
	recordRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	recordRepository.deleteAll();
}

@Override
public List<Records> findByStaffId(Integer staffID) {
	return recordRepository.findByStaffId(staffID);
}

}
