package appsuite.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import appsuite.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	// public List<Product> findAllProducts();
}