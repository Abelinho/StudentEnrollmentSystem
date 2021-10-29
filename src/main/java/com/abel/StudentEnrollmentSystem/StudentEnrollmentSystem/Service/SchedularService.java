package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.Student;

@Component
public class SchedularService {
	
	@Autowired
	private StudentService studentService;
	
	//get each students birthdate
	
	//if the birthdate returned ===same as today
			
	//call sendbirthdaymessage()
	
	@Scheduled(cron = "02 40 18 * * *")
	public void checkStudentBirthday() {
		//get all registered students at that instant
		List<Student> students = studentService.findAllStudents();
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd");
		   LocalDateTime now = LocalDateTime.now();
		   
		   String Today = dtf.format(now); //pass in current LocalDateTime to format() of DateTimeFormatter
		
		for (Student student: students ) 
		{ 
			String newDate = String.valueOf(student.getDateOfBirth()).split("-")[1]+"-"+ String.valueOf(student.getDateOfBirth()).split("-")[2];

			if(newDate.equals(Today)){
			  sendNotification(student.getFirstName(),student.getLastName());
			}
		}//endoffor	
		
		
		
	}//endof checkbirthday
	
	public void sendNotification(String firstName, String lastName){

		System.out.println("Happy Birthday " +firstName +" "+ lastName);
		}
}
