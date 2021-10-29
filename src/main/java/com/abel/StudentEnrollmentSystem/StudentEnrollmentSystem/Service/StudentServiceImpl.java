package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.Department;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.Student;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Repository.DepartmentRepository;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Repository.StudentRepository;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.error.StudentNotFoundException;
import lombok.Data;

@Service
@Data
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public List<Student> findStudentByFirstName(String firstName) throws StudentNotFoundException {
		List<Student> students = studentRepo.findByFirstName(firstName);

		if (students.isEmpty() || students == null) {
			throw new StudentNotFoundException("Student Not Available");
		}
		return students;
	}

	@Override
	public List<Student> findStudentByLastName(String lastName) throws StudentNotFoundException {
		List<Student> students = studentRepo.findByLastName(lastName);

		if (students.isEmpty() || students == null) {
			throw new StudentNotFoundException("Student Not Available");
		}
		return students;
	}

	@Override
	public List<Student> findStudentByOtherNames(String otherNames) throws StudentNotFoundException {
		List<Student> students = studentRepo.findByOtherNames(otherNames);
		if (students.isEmpty() || students == null) {
			throw new StudentNotFoundException("Student Not Available");
		}
		return students;
	}

	@Override
	public List<Student> findStudentByGender(String gender) throws StudentNotFoundException {
		List<Student> students = studentRepo.findByGender(gender);
		if (students.isEmpty() || students == null) {
			throw new StudentNotFoundException("Student Not Available");
		}
		return students;
	}

	@Override
	public List<Student> findStudentByDept(String dept) throws StudentNotFoundException {
		List<Student> students = studentRepo.findByDepartment(dept);
		if (students.isEmpty() || students == null) {
			throw new StudentNotFoundException("Student Not Available");
		}
		return students;
	}

	@Override
	public List<Student> findStudentByMatricNum(String matricNum) throws StudentNotFoundException {
		List<Student> students = studentRepo.findByMatricNumber(matricNum);
		if (students.isEmpty() || students == null) {
			throw new StudentNotFoundException("Student Not Available");
		}
		return students;
	}

	@Override
	public Student addStudent(Student student) throws Exception {
		// check if student is between 18 and 25 and add
		// ..else do not add
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(student.getDateOfBirth().getYear(), student.getDateOfBirth().getMonthValue(),
				student.getDateOfBirth().getDayOfMonth());
		System.out.println(student.getDateOfBirth().getYear());
		System.out.println(student.getDateOfBirth().getMonthValue());
		System.out.println(student.getDateOfBirth().getDayOfMonth());
		Period p = Period.between(birthday, today);
		System.out.println(p);
		String[] strArr = String.valueOf(p).split("Y");
		int age = Integer.parseInt(strArr[0].replace("P", ""));
		// if id is one digit set Matric num to flexiSAF/00 + id
		// else if id is two digits set mat num to flexiSAF/0 + id
		// else if id is 3 digits set mat num to flexiSAF/ + id
		int digits = Long.toString(student.getId()).trim().length();

		//if the student's age is within range
		if (age >= 18 && age <= 25) {
			
			//get id of the student's dept
			Long departmentId = student.getDepartment().getId();
			// fetch the department from database
			Department department = departmentRepo.findById(departmentId)
					.orElseThrow(() -> new RuntimeException("department not found"));
			// create bidirectional reference between student and department
			System.out.println(department);
			student.setDepartment(department);
			studentRepo.save(student);
			//generate matric num according to Id
			if (digits == 1) {
				student.setMatricNumber("FLEXISAF/" + "00" + student.getId());
			} else if (digits == 2) {
				student.setMatricNumber("FLEXISAF/" + "0" + student.getId());
			} else {
				student.setMatricNumber("FLEXISAF/" + student.getId());
			}
			// save student
			return studentRepo.save(student);
		} else {
			throw new Exception("The students age is out of range");
		}

	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student findStudentbyId(long id) throws StudentNotFoundException {
		return studentRepo.getById(id);
	}

	@Override
	public void deleteStudent(long id) throws IllegalArgumentException, StudentNotFoundException {
		studentRepo.deleteById(id);
	}
	
	@Override
	public Student updateStudent(Student student) throws StudentNotFoundException {

		Student savedStudent = findStudentbyId(student.getId());
		// get id of the student's dept
		Long departmentId = student.getDepartment().getId();
		// fetch the department from database
		Department department = departmentRepo.findById(departmentId)
				.orElseThrow(() -> new RuntimeException("department not found"));
		// create bidirectional reference between student and department
		savedStudent.setDepartment(department);
		savedStudent.setFirstName(student.getFirstName());
		savedStudent.setGender(student.getGender());
		savedStudent.setLastName(student.getLastName());
		savedStudent.setOtherNames(student.getOtherNames());
	 return	studentRepo.save(savedStudent);
	}

	@Override
	public List<Student> studentSearch(String searchValue) {
		return studentRepo.studentSearch(searchValue);
	}
	
}
