package com.specialist.controller;

import com.specialist.entity.SpecialistModel;
import com.specialist.service.SpecialistService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CrossOrigin is require for connection of frontend and backend so that data
 * display on frontend. RestController is an annotation for RESTful web
 * services.
 * 
 * @author POD4
 * 
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/specialists")
public class SpecialistController {
	
	/**
	 * Autowired is used for creating object of a class and from this we can use its members. Here 'service' is object of "SpecalsitService".
	 */
	
	@Autowired
	private SpecialistService service;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpecialistController.class);
	
	/**
	 * Return the details of all the specialists
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<SpecialistModel> findAllSpecialists() {
		LOGGER.info("findAllSpecialists method is running");
		LOGGER.info("findAllSpecialists method is ended");
		return service.getSpecialist();
	}

	/**
	 * Return the detail of specialist have ID=id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public SpecialistModel findSpecialistById(@PathVariable int id) {
		LOGGER.info("findSpecialistById method is running");
		LOGGER.info("findSpecialistById method is ended");
		return service.getSpecialistById(id);
	}
	
	/**
	 * Create a new specialist
	 * 
	 * @param specialist
	 * @return
	 */
	@PostMapping("/add")
	public SpecialistModel addSpecialist(@RequestBody SpecialistModel specialist) {
		LOGGER.info("addSpecialists method is running");
		LOGGER.info("addSpecialists method is ended");
		return service.saveSpecialist(specialist);
	}

	/**
	 * Update the details of Specialist
	 * 
	 * @param specialist
	 * @return
	 */
	@PutMapping("/update")
	public SpecialistModel updateSpecialist(@RequestBody SpecialistModel specialist) {
		LOGGER.info("updateSpecialists method is running");
		LOGGER.info("updateSpecialists method is ended");
		return service.updateSpecialist(specialist);
	}

	/**
	 * Delete a specialist with ID=id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public String deleteSpecialist(@PathVariable int id) {
		LOGGER.info("deleteSpecialist method is running");
		LOGGER.info("deleteSpecialist method is ended");
		return service.deleteSpecialist(id);
	}
}
