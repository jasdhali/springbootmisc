package com.example.redis;


import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/students")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping(value = "/add")
	public Student addStudent() {
		Student student = new Student(
				  "Eng2015001", "John Doe", Student.Gender.MALE, 1);
				studentRepository.saveStudent(student);
		return student;
	}

	@PostConstruct
	public void init(){
		Student engStudent = 
				  new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
				Student medStudent = 
				  new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
				studentRepository.saveStudent(engStudent);
				studentRepository.saveStudent(medStudent);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<Object, Object> getStudents() {
		Map<Object, Object> retrievedStudents = 
				  studentRepository.findAllStudents();
		return retrievedStudents;
	}
	
	@RequestMapping(value = "/{id}")
	public Student getStudent(@PathVariable int id) {
		Student retrievedStudent = 
				  studentRepository.findStudent("Eng2015001");
		return retrievedStudent;
	}

/*	@RequestMapping(value = "/search/name/{name}")
	public List<Book> getBookByName(@PathVariable String name) {
		List<Book> books = studentRepository.findByName(name);
		return books;
	}

	@RequestMapping(value = "/search/name/match/{name}")
	public List<Book> getBookByNameMatch(@PathVariable String name) {
		List<Book> books = studentRepository.findByNameMatch(name);
		return books;
	}

	@RequestMapping(value = "/search/param/{name}/{author}/{price}")
	public List<Book> getBookByNamedParam(@PathVariable String name, @PathVariable String author,
			@PathVariable long price) {
		List<Book> books = studentRepository.findByNamedParam(name, author, price);
		return books;
	}

	@RequestMapping(value = "/search/price/{price}")
	public List<Book> getBookByPrice(@PathVariable int price) {
		List<Book> books = studentRepository.findByPrice(price);
		return books;
	}

	@RequestMapping(value = "/search/price/{price1}/{price2}")
	public List<Book> getBookByPriceRange(@PathVariable int price1, @PathVariable int price2) {
		List<Book> books = studentRepository.findByPriceRange(price1, price2);
		return books;
	}

	@RequestMapping(value = "/search/{name}/{author}")
	public List<Book> getBookByNameAndAuthor(@PathVariable String name, @PathVariable String author) {
		List<Book> books = studentRepository.findByNameAndAuthor(name, author);
		return books;
	}*/
}
