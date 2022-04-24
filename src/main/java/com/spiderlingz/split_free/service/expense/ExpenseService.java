package com.spiderlingz.split_free.service.expense;

import com.spiderlingz.split_free.dao.Expense;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ExpenseService {

    String createExpense(Expense expense) throws ExecutionException, InterruptedException;

    String editExpense(long expenseId, Expense expense) throws ExecutionException, InterruptedException;

    List<Expense> getAllExpense() throws ExecutionException, InterruptedException;

    List<Expense> getGroupExpense(long groupId) throws ExecutionException, InterruptedException;

    String deleteExpense(long expenseId) throws ExecutionException, InterruptedException;
}

