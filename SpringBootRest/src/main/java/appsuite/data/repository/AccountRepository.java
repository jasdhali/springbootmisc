package appsuite.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appsuite.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	public Account findByUsername(String username);

}