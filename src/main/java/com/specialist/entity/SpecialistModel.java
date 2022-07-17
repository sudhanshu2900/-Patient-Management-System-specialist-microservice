package com.specialist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Specialist class define the specialist entity by defining their attribute.
 * Here we send the data to H2 Database in "DoctorTable" table. We also defined
 * the column name by using @Column annotation
 * 
 * @author POD4
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "DoctorTable")
@ApiModel(description="Details about the specialist")
public class SpecialistModel {

	/**
	 * @Id annotation is used for defining primary key. Here we are
	 * used @GeneratedValue annotation to increment the 'id' column.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes="Unique id of a specialist")
	private int id;
	
	@Column(name="name")
	@ApiModelProperty(notes="Specialist's name")
	private String name;
	
	@Column(name="age")
	@ApiModelProperty(notes="Specialist's age")
	private int age;
	
	@Column(name="gender")
	@ApiModelProperty(notes="Specialist's gender")
	private String gender;
	
	@Column(name="contact_no")
	@ApiModelProperty(notes="Specialist's contact number")
	private int contact_no;
	
	@Column(name="qualification")
	@ApiModelProperty(notes="Specialist's qualification")
	private String qualification;
	
	@Column(name="specialization")
	@ApiModelProperty(notes="Specialist's specialization")
	private String specialization;
	
	@Column(name="address")
	@ApiModelProperty(notes="Specialist's address")
	private String address;

}
