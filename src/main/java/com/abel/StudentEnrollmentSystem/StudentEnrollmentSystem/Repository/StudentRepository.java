package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
public List<Student> findAll();
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByLastName(String lastName);
	
	public List<Student> findByDepartment(String department);
	
	public List<Student> findByGender(String gender);
	
	public List<Student> findByMatricNumber(String matricNumber);

	public List<Student> findByFirstNameAndLastName(String firstName,String lastName);//verify this

	public List<Student> findByOtherNames(String firstName);

	public Student save(Student theStudent);
	
	@Query(value = "SELECT * FROM student WHERE first_name LIKE CONCAT(:searchvalue,'%') OR last_name LIKE CONCAT(:searchvalue,'%') OR other_names LIKE CONCAT(:searchvalue,'%') OR gender LIKE CONCAT(:searchvalue,'%') OR department_id LIKE CONCAT(:searchvalue,'%') OR CONCAT(first_name, ' ',last_name,' ',other_names) LIKE CONCAT(:searchvalue,'%')", nativeQuery = true)
	List<Student> studentSearch(@Param("searchvalue") String searchvalue);
	
	
}
