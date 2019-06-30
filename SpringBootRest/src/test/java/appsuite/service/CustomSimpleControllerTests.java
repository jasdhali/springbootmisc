package appsuite.service;

//
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
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
