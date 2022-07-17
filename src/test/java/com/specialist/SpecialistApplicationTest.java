package com.specialist;

import org.junit.runner.RunWith;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.internal.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.specialist.entity.SpecialistModel;
import com.specialist.repository.SpecialistRepository;
import com.specialist.service.SpecialistService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecialistApplicationTest {

	@MockBean
	private SpecialistRepository repository;
	
	@Autowired
	private SpecialistService service;
	
	/**
	 * Checking for get all specialists
	 */
	@Test
	public void getSpecialistsTest() {
		when(repository.findAll()).thenReturn(Stream.of(new SpecialistModel(1,"Sudhanshu", 21, "Male", 941234567, "MBBS", "ENT", "SWM")).collect(Collectors.toList()));
		assertEquals(1, service.getSpecialist().size());
	}
	
	/**
	 * Checking for save specialist in database
	 */
	@Test
	public void savePatientTest() {
		SpecialistModel specialist = new SpecialistModel(1,"Keshav", 22, "Male", 991234569, "MS, MBBS", "Heart", "JPR");
		when(repository.save(specialist)).thenReturn(specialist);
		assertEquals(specialist, service.saveSpecialist(specialist));
	}
		
	/**
	 * Checking weather specialist is deleted from database or not
	 */
	@Test
	public void deleteSpecialistTest() {		
		SpecialistModel specialist = new SpecialistModel(1,"Keshav", 22, "Male", 991234569, "MBBS, MS", "Heart", "JPR");
		int id = 1;
		service.deleteSpecialist(id);
		assertEquals(0, service.getSpecialist().size());
	}
	
}
