package com.naveen.mbase.controller;

import org.springframework.data.repository.CrudRepository;
import com.naveen.mbase.entity.Account;

public interface IAccountRepository extends CrudRepository<Account, String> {
	public Account findByUsername(String username);
}
