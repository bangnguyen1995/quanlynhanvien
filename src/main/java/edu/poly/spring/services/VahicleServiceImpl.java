package edu.poly.spring.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Vahicle;
import edu.poly.spring.repositories.VahicleRepository;



@Service
public class VahicleServiceImpl implements VahicleService {
@Autowired
private VahicleRepository  vahicleRepository;

@Override
public Vahicle save(Vahicle entity) {
	return vahicleRepository.save(entity);
}

@Override
public <S extends Vahicle> Iterable<S> saveAll(Iterable<S> entities) {
	return vahicleRepository.saveAll(entities);
}

@Override
public Optional<Vahicle> findById(Integer id) {
	return vahicleRepository.findById(id);
}

@Override
public boolean existsById(Integer id) {
	return vahicleRepository.existsById(id);
}

@Override
public Iterable<Vahicle> findAll() {
	return vahicleRepository.findAll();
}

@Override
public Iterable<Vahicle> findAllById(Iterable<Integer> ids) {
	return vahicleRepository.findAllById(ids);
}

@Override
public long count() {
	return vahicleRepository.count();
}

@Override
public void deleteById(Integer id) {
	vahicleRepository.deleteById(id);
}

@Override
public void delete(Vahicle entity) {
	vahicleRepository.delete(entity);
}

@Override
public void deleteAll(Iterable<? extends Vahicle> entities) {
	vahicleRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	vahicleRepository.deleteAll();
}



}
