package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    private long id;
    private long group_id;
    private String description;
    private String date;
    private List<Comment> comments;
    private String details;
    private Boolean email_reminder;
    private String creation_method;
    private String transaction_method;
    private String cost;
    private String currency_code;
    private Map<String,String> receipt;
    private Map<String,String> category;
    private List<Repayment> repayments;
    private List<UserShare> users;
    private String created_at;
    private User created_by;
    private String updated_at;
    private User updated_by;
    private String deleted_at;
    private User deleted_by;
}
