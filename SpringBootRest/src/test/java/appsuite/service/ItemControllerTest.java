package appsuite.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import appsuite.domain.Item;
import appsuite.domain.User;
import appsuite.exceptions.ServiceException;
import appsuite.web.ItemController;
import appsuite.web.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class ItemControllerTest {
	private static final int UNKNOWN_ID = Integer.MAX_VALUE;		
	private MockMvc mockMvc;
	//MockMvc is the main entry point for server-side Spring MVC test support. 
	//Perform a request and return a type that allows chaining further actions, such as asserting 
	//expectations, on the result.
	
	@Mock 
    private ItemService itemService;
	//@Mock creating a mock. This can also be achieved by using org.mockito.mock(..) method.
    
	@InjectMocks
    private ItemController itemController;
	//@InjectMocks injects mock or spy fields into tested objects automatically.
	
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(itemController)
                //.addFilters(new CORSFilter())
                .build();
    }

    
	//@Autowired
	//private WebApplicationContext wac;
	//private MockMvc mockMvc;

	/*@Mock
    private static ItemService itemService;*/
	
	/*@BeforeClass
	public static void init(){
		itemService = mock(ItemService.class);
	}*/
	
	/*@Configuration
	@EnableAutoConfiguration
	public static class Config {
		@Bean
		public ItemController itemController() {
			ItemController itemController = new ItemController();
			itemController.setItemService(itemService);
			return itemController;
		}
		
		@Bean
		public ItemService itemService() {
			ItemService itemService = new ItemServiceImpl();
			return itemService;
		}
	}*/
	
	
	
	/*@Test
	public void getItemsTestSuccess_1(){
		assertEquals("A","A");
	}*/
    
    @Test
    public void getItemsTestSuccess() throws Exception {
		Collection<Item> items = Arrays.asList(
	            new Item(1, "Item1",20),
	            new Item(2, "Item2",30));
	    when( itemService.getItems()).thenReturn( items );
	    this.mockMvc.perform(get("/items").accept(MediaType.parseMediaType("application/json;charset=UTF-8"))) 
        .andExpect(status().isOk())
        .andExpect((ResultMatcher) content().contentType( "application/json;charset=UTF-8" ))
        //.andExpect( jsonPath("$", hasSize(2)))
        .andExpect( jsonPath("$[0].id", is(1)))
        .andExpect( jsonPath("$[0].sku", is("Item1")))
        .andExpect( jsonPath("$[0].reorderQuantity", is(20)))
        .andExpect( jsonPath("$[1].id", is(2)))
        .andExpect( jsonPath("$[1].sku", is("Item2")))
        .andExpect( jsonPath("$[1].reorderQuantity", is(30)))
        ;
        //verify( userService , times(1)).findAllUsers();
        //verifyNoMoreInteractions( userService );   
    }
    
    //@Test
    public void test_create_user_fail_404_not_found() throws Exception {
        Item item = new Item("Junk UserName");
        when( itemService.exists(item) ).thenReturn(true);
        mockMvc.perform( post("/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        //.content( asJsonString( user )) 
                        )
                .andExpect( status().isBadRequest() );
        verify(itemService, times(1)).exists( item );
        verifyNoMoreInteractions( itemService );
    }
    
    //Simulate a call for all the items with an exception.
    
    @Test(expected= ServiceException.class)
    public void getItemsTestException() throws Exception {
    	when( itemService.getItems()).thenThrow(new ServiceException("Service exception from test method."));
    	
    }
    
}


/*@InjectMocks
private ItemController itemController;*/
