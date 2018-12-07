package com.spring.rest.emprofile;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.controller.SimpleController;

@RunWith(SpringRunner.class)
@WebMvcTest(SimpleController.class)
@Ignore
public class SimpleControllerTest {
	@Autowired MockMvc mockMvc;
	
	@Autowired ObjectMapper objectMapper;
	
	
	@Test
	public void valid_symbol_buy_success() throws Exception{
		
 /*       mockMvc.perform(post("/buy")
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(new Position(new Stock("Foo",""),100)))
            .andExpect(jsonPath("$.name", is("Foo")))
            .andExpect(jsonPath("$.number", notNullValue()));*/
		mockMvc.perform( post("/buy")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
}
