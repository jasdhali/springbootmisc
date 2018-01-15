package appsuite.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appsuite.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
