package com.in28minutes.springboot.controller;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(value = StudentController.class, secure = false) 
public class StudentControllerTest {
	@Autowired 
	private MockMvc mockMvc;
	@MockBean private StudentService studentService;
	
	
	Course mockCourse = new Course("Course1", "Spring", "10 Steps",
			Arrays.asList("Learn Maven", "Import Project", "First Example",
					"Second Example"));

	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";

	@Test
	public void contextLoads() {
		Mockito.when(
				studentService.retrieveCourse(Mockito.anyString(),
						Mockito.anyString())).thenReturn(mockCourse);

	}

}
