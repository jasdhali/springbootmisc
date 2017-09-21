package appsuite.controllers;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import appsuite.domain.Book;
import appsuite.service.BookService;
import appsuite.web.BooksController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BooksController.class, secure = false)
public class BookControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	Book book = new Book();

	public Book getBookTest() {
		Mockito.when(bookService.findOne(Mockito.anyLong())).thenReturn(book);
		return book;

	}
}
