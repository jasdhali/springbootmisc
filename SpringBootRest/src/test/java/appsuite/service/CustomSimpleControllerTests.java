package appsuite.service;

//
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
//
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import appsuite.web.CustomSimpleController;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomSimpleController.class)
public class CustomSimpleControllerTests {
	@Autowired
    private MockMvc mockMvc;

    @Test
    public void testSayHelloWorld() throws Exception {
        this.mockMvc.perform(get("/hi").accept(MediaType.parseMediaType("text/plain;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                //.andExpect( (ResultMatcher)content().string(equalsTo("Greetings from Spring Boot!")))
                ;
    }
	

}

/**

Content-Length →12
Content-Type →text/plain;charset=UTF-8
Date →Fri, 09 Dec 2016 17:29:34 GMT
X-Application-Context →application:8080

*/
