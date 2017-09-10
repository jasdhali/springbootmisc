package com.springjpa.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_HTML;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.*;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;

//https://www.blazemeter.com/blog/spring-boot-rest-api-unit-testing-with-junit
//http://www.baeldung.com/spring-boot-testing
@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
public class WebControllerTest {

	@Autowired
	private MockMvc mvc;
	
	//@MockBean
	//private WebController webController;
	
	@MockBean
	private CustomerRepository repository;
	
	@Test
	public void findAllCust_JSON_Success() throws Exception{
		Customer cust = new Customer("jas","singh");
		List<Customer> listCust = new ArrayList<Customer>();
		listCust.add( cust );
		
		given( repository.findAll() ).willReturn( listCust );
		
		mvc.perform( get("/findall/v1")
			.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$" , hasSize(1)))
		.andExpect( jsonPath("$[0].firstName" , is(cust.getFirstName())))
		;
	}
	@Test
	public void saveCust_Success() throws Exception{
		Customer cust = new Customer("jas","singh");
		List<Customer> listCust = new ArrayList<Customer>();
		listCust.add( cust );
		
		given( repository.findAll() ).willReturn( listCust );
		
		mvc.perform( get("/findall/v1")
			.contentType(MediaType.TEXT_HTML))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$" , hasSize(1)))
		.andExpect( jsonPath("$[0].firstName" , is(cust.getFirstName())))
		;
	}
	/*
	@Test
	public void findAllHTMLSUCCESS() throws Exception{
		//given(  webController.findAll() ).willReturn( "X",getCustomersTest());
		//Mockito.when(webController.findAll()).thenReturn( getCustomersTest() );
		//Mocito.do
		Mockito.doReturn( getCustomersTest() ).when(webController).findAll();

		mvc.perform(get("findAll")
	               //.with(user("blaze").password("Q1w2e3r4"))
	               .contentType(TEXT_HTML))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("$", hasSize(1)))
	               .andExpect(jsonPath("$[0].jas", is(getTestCust().getFirstName())));
	}
	*/
	
/*	@Test
	public void findAllJSONSUCCESS() throws Exception{
		//given(  webController.findAll() ).willReturn( "X",getCustomersList());
		//Mockito.when(webController.findAll()).thenReturn( getCustomersTest() );
		//Mocito.do
		Mockito.doReturn( getCustomersList() ).when(webController).findAllV1();

		mvc.perform(get("findAll")
	               //.with(user("blaze").password("Q1w2e3r4"))
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("$", hasSize(1)))
	               .andExpect(jsonPath("$[0].jas", is(getTestCust().getFirstName())));
	}*/
	
	private List<Customer> getCustomersList(){
		List<Customer> listCust = new ArrayList<Customer>();
		listCust.add( getTestCust() );
		return listCust;
	}
	
	private Customer getTestCust(){
		Customer cust = new Customer("jas","singh");
		return cust;
	}
	
}
