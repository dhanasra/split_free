package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String registration_status;
    private String picture;
    private List<Map<String,String>> balance;
    private Map<String, Map<String,String>> groups;
    private String phoneNumber;
    private String currencyCode;
}
