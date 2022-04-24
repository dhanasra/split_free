package com.spiderlingz.split_free.service.expense.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.spiderlingz.split_free.dao.Expense;
import com.spiderlingz.split_free.service.expense.ExpenseService;
import com.spiderlingz.split_free.service.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    public static final String COL_NAME="expense";

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public String createExpense(Expense expense) throws ExecutionException, InterruptedException {
        List<Expense> expenses = getAllExpense();
        Expense lastExpense = expenses.size()!=0 ? expenses.get(expenses.size()-1) : null;
        long lastExpenseId = lastExpense!=null ? lastExpense.getId() : -1;
        expense.setId(lastExpenseId+1);
        String id = String.valueOf(expense.getId());
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).set(expense);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public List<Expense> getAllExpense() throws ExecutionException, InterruptedException {
        List<Expense> expenses = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future  = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            expenses.add(document.toObject(Expense.class));
        }
        return expenses;
    }

    @Override
    public List<Expense> getGroupExpense(long groupId) throws ExecutionException, InterruptedException {
        List<Expense> expenses = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future  = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            Expense expense = document.toObject(Expense.class);
            if(expense!=null && expense.getGroup_id()==groupId) {
                expenses.add(expense);
            }
        }
        return expenses;
    }

    @Override
    public String editExpense(long expenseId, Expense expense) throws ExecutionException, InterruptedException {
        String id = String.valueOf(expenseId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).set(expense);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteExpense(long expenseId) throws ExecutionException, InterruptedException {
        String id = String.valueOf(expenseId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).delete();
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
