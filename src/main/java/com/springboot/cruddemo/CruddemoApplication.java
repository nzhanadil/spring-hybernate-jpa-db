package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// readStudent(studentDAO);

			//queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findByLastName("doe");

		// display list of students
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findAll();

		// display list of students
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object.....");
		Student tempStudent = new Student("yoyo", "Doe", "paul@gmail.com");

		// save the student object
		System.out.println("saving the student....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving the student with id: " + theId);
		Student student = studentDAO.findById(theId);

		// display the student
		System.out.println("Found the student" + student);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object.....");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

		// save the student object
		System.out.println("saving the student....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
