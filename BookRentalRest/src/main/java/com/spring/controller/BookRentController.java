package com.spring.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.rest.domain.Book;
import com.spring.rest.domain.BookRental;
import com.spring.service.BookRentalService;

@RestController
@RequestMapping("/bookrent")
public class BookRentController {
	private final Logger logger = LoggerFactory.getLogger(BookRentController.class);
	@Autowired
	private BookRentalService bookRentalService;
	
	
	/*@RequestMapping( value = "/rent/{id}" , method = RequestMethod.GET )
	public ResponseEntity<String> rentBookById(@PathVariable String id){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
		Book book = restTemplate.getForObject("http://192.168.5.101:8383/books/1", Book.class);
		logger.debug( "Found book >>> " + book );
		bookRentalService.createRental(getSampleRental());
		return new ResponseEntity("BookRented" , HttpStatus.OK);
	}
*/	
	@RequestMapping( value = "/rent/{id}" , method = RequestMethod.GET )
	public ResponseEntity<BookRental> rentBookById(@PathVariable String id){
		return new ResponseEntity(bookRentalService.getRentalById( id ) , HttpStatus.OK);
	}
	
	private BookRental getSampleRental(){
		return new BookRental(1,"1" ,new Date(),"23");
	}
	
	
	@RequestMapping( value = "/rent/all" ,  method = RequestMethod.GET)
 	public List<BookRental> getAllRentals(){
 		return bookRentalService.getAllRentals();
 	}
}
