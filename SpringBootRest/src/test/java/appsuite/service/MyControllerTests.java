package appsuite.service;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import appsuite.domain.Item;
import appsuite.web.ItemController;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class MyControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ItemService itemService;

	@InjectMocks
	private ItemController itemController;

	/*@MockBean
	private UserVehicleService userVehicleService;*/

	@Test
	public void testExample() throws Exception {
		given(this.itemService.getItem(10l)).willReturn(new Item(10,"Honda", 23));
		/*this.mvc.perform(get("/items/10").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string("Honda Civic"));*/
		this.mvc.perform(get("/items/10").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}