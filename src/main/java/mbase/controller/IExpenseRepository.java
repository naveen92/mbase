package main.java.mbase.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import main.java.mbase.model.Expense;

public interface IExpenseRepository extends CrudRepository<Expense, Long> {

	List<Expense> findByParent(String parent);
}
