package com.naveen.mbase.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.naveen.mbase.entity.Expense;

public interface IExpenseRepository extends CrudRepository<Expense, Long> {

	List<Expense> findByParent(String parent);
}
