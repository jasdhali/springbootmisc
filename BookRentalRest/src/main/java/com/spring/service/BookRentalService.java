package com.spring.service;

import java.util.List;

import com.spring.rest.domain.BookRental;

public interface BookRentalService {
	public void createRental(BookRental book);	
	public List<BookRental> getAllRentals(); 
}
