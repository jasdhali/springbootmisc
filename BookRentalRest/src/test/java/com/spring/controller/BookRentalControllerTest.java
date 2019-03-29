package com.spring.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.domain.BookRental;
import com.spring.service.BookRentalService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {BookRentController.class})
public class BookRentalControllerTest {

	@Autowired  private MockMvc mvc;
	
	@MockBean
	private BookRentalService bookRentalService;

	@Autowired ObjectMapper objectMapper;

	@Value("${oracle2.username}")
	private String configProp;
	
	@Test
	public void testGetSingleBookRental() throws Exception{
		
	BookRental bookRental = new BookRental(1l,"1",new Date(), "23");
	String bookRentalJson = objectMapper.writeValueAsString(bookRental);
	when( bookRentalService.getRentalById("1")).thenReturn(bookRental);
	
/*	MockMvcRequestBuilders requestBuilders  = 
			MockMvcRequestBuilders.get("/bookrent/rent/{id}").buildRequest(servletContext);
*/	
	ResultActions actions = mvc.perform(get("/bookrent/rent/1")
		      .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(status().isOk())
		      ;
	MvcResult mvcResult = actions.andReturn();
	MockHttpServletResponse servletResponse = mvcResult.getResponse();
	System.out.println( servletResponse.getContentAsString() );
	}
}
