package appsuite.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import appsuite.domain.Book;


public interface BookNamedQueryRepositoryExample extends JpaRepository<Book, Long> {
	// Query will be used from Named query defined at Entity class
	List<Book> findByPrice(long price);
}
