package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.Student;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Service.StudentService;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.error.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//save a student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) throws Exception {
			return studentService.addStudent(student);
	}
	
	//retrieve ALL students
	//@GetMapping("/students")
	@RequestMapping(
			  value = "/students", 
			  method = RequestMethod.GET, 
			  produces = "application/json"
			)
	public List<Student> getAllStudents() {
		return studentService.findAllStudents();
	}
	
	//update a student
	@PutMapping("/students")
	public Student updatStudent(@RequestBody Student student) throws StudentNotFoundException {
		
		return studentService.updateStudent(student);
	}
	
   //Delete a student(by id)
   @DeleteMapping("/students")	
	public void deleteStudent(@RequestParam int id) throws IllegalArgumentException, StudentNotFoundException {
	   studentService.deleteStudent(id);
		
	}
   
   @GetMapping("/students/search")
   public List<Student> studentSearch(@RequestParam String searchValue) {
	return studentService.studentSearch(searchValue);
}
   
    public String checkBirthday(Student student) {
		return "";
	}
	
}
