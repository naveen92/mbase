package main.java.mbase.controller;

import org.springframework.data.repository.CrudRepository;
import main.java.mbase.auth.Account;

public interface IAccountRepository extends CrudRepository<Account, String> {
	public Account findByUsername(String username);
}
