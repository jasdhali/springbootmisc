package appsuite.controllers;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import appsuite.domain.Item;
import appsuite.exceptions.ServiceException;
import appsuite.service.ItemService;
import appsuite.web.ItemController;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class , secure=false)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;

	Item mockItem = new Item(10l,"Item10",20);
	String exampleJson = "{\"id\":\"10\",\"sku\":\"Item10\",\"reorderQuantity\":\"20\"}";
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetItem_SUCCESS() throws Exception {
		Mockito.when(
				itemService.getItem(Mockito.anyLong()) 
				).thenReturn(mockItem);
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get("/items/10").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println( result.getResponse() );
		String expected = "{\"id\":10,\"sku\":\"Item10\",\"reorderQuantity\":20}";
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	/*
	@Test
	public final void testAddItem_SUCCESS() throws Exception {
		Mockito.doNothing().when(itemService).addItem(mockItem);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/items/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println( result.getResponse().getContentAsString() );
		String expected = "{\"id\":10,\"sku\":\"Item10\",\"reorderQuantity\":20}";
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	*/
}
