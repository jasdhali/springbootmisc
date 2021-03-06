package appsuite.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appsuite.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);

}