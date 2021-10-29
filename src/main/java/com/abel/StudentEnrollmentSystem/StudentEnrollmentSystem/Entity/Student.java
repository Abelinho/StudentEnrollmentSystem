package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name="student")
public class Student{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String otherNames;
	private String gender;
	private LocalDate dateOfBirth;
	private String matricNumber;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;
}
