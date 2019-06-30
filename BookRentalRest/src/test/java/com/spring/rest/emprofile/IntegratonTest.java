package com.spring.rest.emprofile;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.spring.controller.SimpleController;
import com.spring.rest.domain.Position;
import com.spring.rest.domain.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes=SimpleController.class
		)
@AutoConfigureMockMvc
@Ignore
public class IntegratonTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	//@Autowired
    //private TestRestTemplate restTemplate;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void buy_valid_symbol_validateResponse() throws Exception{
		Position pos = new Position(new Stock("IBM","This is a test stock") , 100);
		String positionAsJson = JsonUtil.convertPositionAsJson(pos);
		ResultActions resultActions = mockMvc.perform( post("/buy").content(positionAsJson).contentType(MediaType.APPLICATION_JSON) );
		resultActions.andExpect(status().isOk()).andReturn();
		
		//MvcResult  mvcResult = resultActions.andReturn();
		//String bodyAsString = mvcResult.getResponse().getContentAsString();
		//assertEquals( "Bought 100 shares of com.spring.controller.Stock@5851e3dc", bodyAsString);
	}
}
