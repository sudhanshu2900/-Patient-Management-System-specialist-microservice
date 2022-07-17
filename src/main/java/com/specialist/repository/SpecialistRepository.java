package com.specialist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.specialist.entity.SpecialistModel;

/**
 * JpaRepository (Java Persistence API): It contains the API for CRUD (Create,
 * Read, Update, Delete) operation on data. Here we used findByName() from
 * JpaRepository.
 * 
 * @author POD4
 *
 */

public interface SpecialistRepository extends JpaRepository<SpecialistModel, Integer> {
	SpecialistModel findByName(String name);
}
