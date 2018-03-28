package appsuite.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import appsuite.domain.Book;
import appsuite.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BooksController {
	@Autowired
	private BookService bookService;

	@RequestMapping( method = RequestMethod.POST )
	public ResponseEntity<String> addBook(@RequestBody Book book) {
	
		if( bookService.findOne(book.getId()) != null){
			return new ResponseEntity<String>("Book with id >> " + book.getId() + " already available wither delete it first or changes Id", HttpStatus.OK);
		}
		bookService.saveBook(book);
		return new ResponseEntity<String>("New book added successfully", HttpStatus.OK);
	}

	@RequestMapping( method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable int id) {
		Book book = new Book();
		book.setId(id);
		bookService.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Book> getBooks() {
		return bookService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/xml", produces = { MediaType.APPLICATION_XML_VALUE })
	public List<Book> getBooksXML() {
		return bookService.findAll();
	}

	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public Book getBook(@PathVariable int id) {
		Book book = bookService.findOne(id);
		return book;
	}

	@RequestMapping(value = "/search/name/{name}" , method = RequestMethod.GET)
	public List<Book> getBookByName(@PathVariable String name) {
		List<Book> books = bookService.findByName(name);
		return books;
	}

	@RequestMapping(value = "/search/name/match/{name}" ,method = RequestMethod.GET)
	public List<Book> getBookByNameMatch(@PathVariable String name) {
		List<Book> books = bookService.findByNameMatch(name);
		return books;
	}

	@RequestMapping(value = "/search/param/{name}/{author}/{price}" ,method = RequestMethod.GET)
	public List<Book> getBookByNamedParam(@PathVariable String name, @PathVariable String author,
			@PathVariable long price) {
		List<Book> books = bookService.findByNamedParam(name, author, price);
		return books;
	}

	@RequestMapping(value = "/search/price/{price}" ,method = RequestMethod.GET)
	public List<Book> getBookByPrice(@PathVariable int price) {
		List<Book> books = bookService.findByPrice(price);
		return books;
	}

	@RequestMapping(value = "/search/price/{price1}/{price2}" ,method = RequestMethod.GET)
	public List<Book> getBookByPriceRange(@PathVariable int price1, @PathVariable int price2) {
		List<Book> books = bookService.findByPriceRange(price1, price2);
		return books;
	}

	@RequestMapping(value = "/search/{name}/{author}",method = RequestMethod.GET)
	public List<Book> getBookByNameAndAuthor(@PathVariable String name, @PathVariable String author) {
		List<Book> books = bookService.findByNameAndAuthor(name, author);
		return books;
	}
}
