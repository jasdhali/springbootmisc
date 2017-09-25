package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.domain.BookRental;

public interface BookRentalRepository extends JpaRepository<BookRental,Long>  {
	
}
