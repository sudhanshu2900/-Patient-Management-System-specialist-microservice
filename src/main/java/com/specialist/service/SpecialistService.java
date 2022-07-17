package com.specialist.service;

import com.specialist.entity.SpecialistModel;
import com.specialist.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * SpecialistService class contains some methods that use JpaRepository functions
 * and perform some operations. Here we define the function for creating,
 * writing, deleting, updating data.
 * 
 * @author POD4
 *
 */

@Service
public class SpecialistService {
	
	@Autowired
	private SpecialistRepository repository;

	public SpecialistModel saveSpecialist(SpecialistModel specialist) {
		return repository.save(specialist);
	}

	public List<SpecialistModel> saveSpecialists(List<SpecialistModel> specialists) {
		return repository.saveAll(specialists);
	}

	public List<SpecialistModel> getSpecialist() {
		return repository.findAll();
	}

	public SpecialistModel getSpecialistById(int id) {
		return repository.findById(id).orElse(null);
	}

	public SpecialistModel getSpecialistByName(String name) {
		return repository.findByName(name);
	}

	public String deleteSpecialist(int id) {
		repository.deleteById(id);
		return "Specialist is removed !! " + id;
	}

	public SpecialistModel updateSpecialist(SpecialistModel specialist) {
		SpecialistModel existingSpecialist = repository.findById(specialist.getId()).orElse(null);
		existingSpecialist.setName(specialist.getName());
		existingSpecialist.setAge(specialist.getAge());
		existingSpecialist.setGender(specialist.getGender());
		existingSpecialist.setContact_no(specialist.getContact_no());
		existingSpecialist.setQualification(specialist.getQualification());
		existingSpecialist.setSpecialization(specialist.getSpecialization());
		existingSpecialist.setAddress(specialist.getAddress());
		return repository.save(existingSpecialist);
	}

}
