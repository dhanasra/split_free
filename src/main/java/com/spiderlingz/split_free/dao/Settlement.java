package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Settlement {
    private long id;
    private String cost;
    private String currencyCode;
    private String groupId;
    private String categoryId;
    private String date;
    private String description;
    private String createdMethod;
    private Boolean payment;
    private Boolean settleAll;
    private String transactionMethod;
    private Map<String, Map<String,String>> members;
}
