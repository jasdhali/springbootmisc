package appsuite.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import appsuite.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByName(String name);
}
