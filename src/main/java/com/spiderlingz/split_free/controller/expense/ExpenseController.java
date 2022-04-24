package com.spiderlingz.split_free.controller.expense;

import com.spiderlingz.split_free.dao.Expense;
import com.spiderlingz.split_free.service.expense.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/split_free/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public String createExpense(@RequestBody Expense expense) throws InterruptedException, ExecutionException {
        return expenseService.createExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpense() throws InterruptedException, ExecutionException {
        return expenseService.getAllExpense();
    }

    @GetMapping("/group/{id}")
    public List<Expense> getGroupExpense(
            @PathVariable(value = "id") long groupId) throws InterruptedException, ExecutionException {
        return expenseService.getGroupExpense(groupId);
    }

    @PutMapping("{id}")
    public String editExpense(
            @PathVariable(value = "id") long expenseId,
            @RequestBody Expense expense) throws InterruptedException, ExecutionException {
        return expenseService.editExpense(expenseId,expense);
    }

    @DeleteMapping("{id}")
    public String deleteExpense( @PathVariable(value = "id") long expenseId ) throws InterruptedException, ExecutionException {
        return expenseService.deleteExpense(expenseId);
    }

}
