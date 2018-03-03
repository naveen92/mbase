package main.java.mbase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.mbase.model.Expense;

@EntityScan("main.java.mbase")
@CrossOrigin(origins = "*")
@RestController
public class ExpenseRestServiceController {
	
	@Autowired
	private IExpenseRepository repo;
	
    // CREATE
    @RequestMapping("/expense/create")
    @ResponseBody
    public String createExpense(int disporder, String title, int amount, String parent) {
        Expense expense = new Expense();
        expense.setDisporder(disporder);
        expense.setTitle(title);
        expense.setAmount(amount);
        expense.setParent(parent);
        
        try {
            repo.save(expense);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "creation successful: " + String.valueOf(expense.getId());
    }
     
    // READ
    @RequestMapping("/expense/read")
    @ResponseBody
    public Expense readExpense(long id) {
    	Expense expense = null;
        try {
        	expense = repo.findOne(id);
        } catch (Exception e) {
        }
        return expense;
    }

    // READ BY PARENT
    @RequestMapping("/expense/readByParent")
    @ResponseBody
    public List<Expense> readExpenseByParent(String parent) {
    	List<Expense> expenses = null;
        try {
        	expenses = repo.findByParent(parent);
        } catch (Exception e) {
        }
        return expenses;
    }

    // UPDATE
    @RequestMapping("/expense/update")
    @ResponseBody
    public String updateExpense(long id, int disporder, String title, int amount, String parent) {
    	Expense expense;
        try {
            expense = repo.findOne(id);
            expense.setDisporder(disporder);
            expense.setTitle(title);
            expense.setAmount(amount);
            expense.setParent(parent);
            repo.save(expense);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Expense details updated successfully.";
    }
 
    // DELETE
    @RequestMapping("/expense/delete")
    @ResponseBody
    public String deleteExpense(long id) {
        try {
            repo.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "deletion successful";
    }
}
