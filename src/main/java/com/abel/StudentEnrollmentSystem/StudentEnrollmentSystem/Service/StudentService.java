package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Service;

import java.util.List;

import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.Student;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.error.StudentNotFoundException;

public interface StudentService {//rename the methods below, move them to repository class
	
	List<Student> findAllStudents();
	
	List<Student> findStudentByFirstName(String firstName) throws StudentNotFoundException;
	
	List<Student> findStudentByLastName(String lastName) throws StudentNotFoundException;
	
	List<Student> findStudentByOtherNames(String otherNames) throws StudentNotFoundException;
	
	List<Student> findStudentByGender(String gender) throws StudentNotFoundException;
	
	List<Student> findStudentByDept(String dept) throws StudentNotFoundException;
	
	List<Student> findStudentByMatricNum(String matricNum) throws StudentNotFoundException;
    
	Student findStudentbyId(long id) throws StudentNotFoundException; 
    
	Student addStudent(Student student) throws Exception;
	
	void deleteStudent(long id) throws IllegalArgumentException,StudentNotFoundException;
	
	Student updateStudent(Student student) throws StudentNotFoundException;
	
	List<Student> studentSearch(String searchValue);
	
	
}
