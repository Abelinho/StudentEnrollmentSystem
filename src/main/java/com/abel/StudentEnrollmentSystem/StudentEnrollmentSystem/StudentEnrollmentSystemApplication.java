package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentEnrollmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEnrollmentSystemApplication.class, args);
	}

}
