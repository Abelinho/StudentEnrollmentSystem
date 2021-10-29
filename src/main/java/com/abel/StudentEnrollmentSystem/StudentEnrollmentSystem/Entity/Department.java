package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class Department{

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;	
 @Column(name = "dept_name")	
 private String name;
}
