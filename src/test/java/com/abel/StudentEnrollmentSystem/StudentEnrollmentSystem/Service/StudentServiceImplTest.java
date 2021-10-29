package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.Department;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.Student;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Repository.StudentRepository;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.error.StudentNotFoundException;

@SpringBootTest
class StudentServiceImplTest {
    @Autowired
	StudentService studentservice;
	
    @MockBean
    StudentRepository studentrepo;
    
    
    List<Student> listOfStudents = new ArrayList<Student>();
   Student std1;
	@BeforeEach
	void setUp() throws Exception {
		Student std = Student.builder()
					  .id(1)	
				      .dateOfBirth(LocalDate.of(2001,9,05))
				      .firstName("Mark") 
				      .gender("male")
				      .matricNumber("Flexisaf/004")
				      .department(new Department().builder().id(1).name("science").build())
				      .lastName("John")
				      .otherNames("Apostle")
				      .build();
				      
	    listOfStudents.add(std);
	    
	    Mockito.when(studentrepo.findAll())
        .thenReturn(listOfStudents);
	    
	    
	    std1 = Student.builder()
				  .id(2)	
			      .dateOfBirth(LocalDate.of(2003,8,04))
			      .firstName("Anthony") 
			      .gender("male")
			      .matricNumber("Flexisaf/005")
			      .department(new Department().builder().id(1).name("science").build())
			      .lastName("Jude")
			      .otherNames("Jonas")
			      .build();
	    Mockito.when(studentrepo.getById(2L))
        .thenReturn(std1);
	    
	}

	@Test
	void testFindAllStudents() {
		
		 List<Student> returnedStd = studentservice.findAllStudents();
		assertEquals(listOfStudents ,returnedStd);
	}

	@Test
	void testFindStudentbyId() throws StudentNotFoundException {
   Long stdId =2L;
     Student returnedStudent = studentservice.findStudentbyId(stdId);
     assertEquals(std1, returnedStudent);
	}

	//would have been done but for shortness of time..
//	@Test
//	void testDeleteStudent() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateStudent() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testStudentSearch() {
//		fail("Not yet implemented");
//	}

}
