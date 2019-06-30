package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.domain.Book;

public interface BookRepository extends JpaRepository<Book,Long>  {
	
}
