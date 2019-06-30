package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.repository.BookRentalRepository;
import com.spring.repository.BookRepository;
import com.spring.rest.domain.Book;
import com.spring.rest.domain.BookRental;

@Service
@Transactional
public class BookRentalServiceImpl implements BookRentalService {
	@Autowired
	private BookRentalRepository bookRentalRepository;
	
	public void createRental(BookRental bookRental){
		bookRentalRepository.save(bookRental);
	}
	public List<BookRental> getAllRentals(){
		return bookRentalRepository.findAll();
	}
	public BookRental getRentalById(String id){
		return bookRentalRepository.findOne( Long.valueOf(id) );
	}
	
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	/*
	@Autowired
	private BookOwnRepository bookOwnRepository;
	@Autowired
	private BookQueryRepositoryExample bookQueryRepository;
	@Autowired
	private BookNamedQueryRepositoryExample bookNamedQueryRepository;
	public List<Book> findByName(String name) {
		return bookQueryRepository.findByName(name);
	}

	public List<Book> findByNameMatch(String name) {
		return bookQueryRepository.findByNameMatch(name);
	}

	public List<Book> findByNamedParam(String name, String author, long price) {
		return bookQueryRepository.findByNamedParam(name, author, price);
	}

	public List<Book> findByPriceRange(long price1, long price2) {
		return bookQueryRepository.findByPriceRange(price1, price2);
	}

	public List<Book> findByPrice(long price) {
		return bookNamedQueryRepository.findByPrice(price);
	}

	public List<Book> findByNameAndAuthor(String name, String author) {
		return bookOwnRepository.findByNameAndAuthor(name, author);
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public Book findOne(long id) {
		System.out.println("Cached Pages");
		return bookRepository.findOne(id);
	}

	public void delete(long id) {
		bookRepository.delete(id);
	}
	*/
}
