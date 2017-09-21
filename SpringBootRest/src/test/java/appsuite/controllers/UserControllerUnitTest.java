package appsuite.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import appsuite.domain.User;
import appsuite.service.UserService;
import appsuite.web.UserController;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class)
public class UserControllerUnitTest {
	private static final int UNKNOWN_ID = Integer.MAX_VALUE;
	
	@Autowired
	private MockMvc mockMvc;
	//MockMvc is the main entry point for server-side Spring MVC test support. 
	//Perform a request and return a type that allows chaining further actions, such as asserting 
	//expectations, on the result.
	
	@Mock 
    private UserService userService;
	//@Mock creating a mock. This can also be achieved by using org.mockito.mock(..) method.
    
	@InjectMocks
    private UserController userController;
	//@InjectMocks injects mock or spy fields into tested objects automatically.
	
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                //.addFilters(new CORSFilter())
                .build();
    }
    //MockitoAnnotations.initMocks(this) initializes fields annotated with Mockito annotations.
    
    
    //Test method to test successful get list of all users....
    @Test
    public void test_get_all_success() throws Exception {
    	List<User> users = Arrays.asList(
                new User(1, "Daenerys Targaryen"),
                new User(2, "John Snow"));
    	when(userService.getAll()).thenReturn( users );
    	mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        //.andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].username", is("Daenerys Targaryen")))
        .andExpect(jsonPath("$[1].id", is(2)))
        .andExpect(jsonPath("$[1].username", is("John Snow")));
    	verify(userService, times(1)).getAll();
    	verifyNoMoreInteractions(userService);
    }
    
    //Testing a user creation scenario. User already exists.
    //@Test
    public void test_create_user_fail_404_not_found() throws Exception {
        User user = new User("username exists");
        when(userService.exists(user)).thenReturn(true);
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        //.content( asJsonString( user )) 
                        )
                .andExpect(status().isNotFound());
        verify(userService, times(1)).exists( user );
        verifyNoMoreInteractions(userService);
    }
    /**
     * GET /users/1
Create test data and configure mock object to return the data when the findById() method of the UserService is invoked.
Invoke an HTTP GET request to the /users/1 URI.
Validate if the response is correct.
Verify that the HTTP status code is 200 (OK).
Verify that the content-type of the response is application/json and its character set is UTF-8.
Verify that the id and username attributes are equal to the mocked test data.
Verify that the findById() method of the UserService is invoked exactly once.
Verify that after the response, no more interactions are made to the UserService
     * @throws Exception
     */
    /*@Test
    public void test_get_by_id_success() throws Exception{
    	User user = new User(1, "Daenerys Targaryen");
    	when( userService.findById(1)).thenReturn(user);
    	mockMvc.perform(get("/users/{id}", 1))
    			.andExpect( status().isOk())
    			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
    			.andExpect(jsonPath("$.id", is(1)))
    			.andExpect(jsonPath("$.username", is("Daenerys Targaryen")));
        verify(userService, times(1)).findById(1);
        verifyNoMoreInteractions(userService);
    }*/
    
    @Test
    public void test_get_by_id_success() throws Exception {
        User user = new User(1, "Daenerys Targaryen");
        when(userService.findById(1)).thenReturn(user);
        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.username", is("Daenerys Targaryen")));
        verify(userService, times(1)).findById(1);
        verifyNoMoreInteractions(userService);
    }
    /**
     * Configure mock object to return null when the findById() method of the UserService is invoked.
Invoke an HTTP GET request to the /users/1 URI.
Validate if the response is correct.
Verify that the HTTP status code is 404 (Not Found).
Verify that the findById() method of the UserService is invoked exactly once.
Verify that after the response, no more interactions are made to the UserService
     * @throws Exception
     */
    @Test
    public void test_get_by_id_fail_404_not_found() throws Exception {
        when(userService.findById(1)).thenReturn(null);
        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isNotFound());
        verify(userService, times(1)).findById(1);
        verifyNoMoreInteractions(userService);
    }
 // =========================================== Create New User ========================================


    /**
     * HTTP POST Unit Test: create
POST /users
Configure mocked responses for the UserService exists() and create methods.
Invoke an HTTP POST request to the /users URI. Make sure the content-type is set to application/json. Convert the User object to JSON and add it to the request.
Validate if the response is correct.
Verify that the HTTP status code is 201 (CREATED).
Verify that the location header is set with the path to the created resource.
Verify that the exists() and create() methods of the UserService are invoked exactly once.
Verify that after the response, no more interactions are made to the UserService
     * @throws Exception
     */
    
    @Test
    public void test_create_user_success() throws Exception {
        User user = new User("Arya Stark");
        when(userService.exists(user)).thenReturn(false);
        doNothing().when(userService).create(user);
        mockMvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andExpect(status().isCreated())
                //.andExpect(header().string("location", containsString("http://localhost:8080/users/")))
                ;
        verify(userService, times(1)).exists(user);
        verify(userService, times(1)).create(user);
        verifyNoMoreInteractions(userService);
    }

    
    @Test
    public void test_create_user_fail_409_conflict() throws Exception {
        User user = new User("username exists");
        String jsonUser = asJsonString(user);
        when(userService.exists(user)).thenReturn(true);
        mockMvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andExpect(status().isConflict());
        verify(userService, times(1)).exists(user);
        verifyNoMoreInteractions(userService);
    }

 // =========================================== Update Existing User ===================================

    @Test
    public void test_update_user_success() throws Exception {
        User user = new User(1, "Arya Stark");

        when(userService.findById(user.getId())).thenReturn(user);
        doNothing().when(userService).update(user);

        mockMvc.perform(
                put("/users/{id}", user.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andExpect(status().isOk());

        verify(userService, times(1)).findById(user.getId());
        verify(userService, times(1)).update(user);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void test_update_user_fail_404_not_found() throws Exception {
        User user = new User(UNKNOWN_ID, "user not found");

        when(userService.findById(user.getId())).thenReturn(null);

        mockMvc.perform(
                put("/users/{id}", user.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).findById(user.getId());
        verifyNoMoreInteractions(userService);
    }

    // =========================================== Delete User ============================================

    @Test
    public void test_delete_user_success() throws Exception {
        User user = new User(1, "Arya Stark");

        when(userService.findById(user.getId())).thenReturn(user);
        doNothing().when(userService).delete(user.getId());

        mockMvc.perform(
                delete("/users/{id}", user.getId()))
                .andExpect(status().isOk());

        verify(userService, times(1)).findById(user.getId());
        verify(userService, times(1)).delete(user.getId());
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void test_delete_user_fail_404_not_found() throws Exception {
        User user = new User(UNKNOWN_ID, "user not found");

        when(userService.findById(user.getId())).thenReturn(null);

        mockMvc.perform(
                delete("/users/{id}", user.getId()))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).findById(user.getId());
        verifyNoMoreInteractions(userService);
    }
    
    
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

